package specs

import geb.spock.GebReportingSpec
import org.openqa.selenium.Keys
import pages.ContactUsPage
import pages.GoogleGroovyPage
import pages.SecurePayHomePage

class testSpec extends GebReportingSpec {

    def 'Open Google page' () {
        when:' open Google page'
        GoogleGroovyPage googleGroovyPage = to GoogleGroovyPage

        then:'verify if google page is loaded completely'
        waitFor { googleGroovyPage.searchField.displayed }

        when: 'user searches for SecurePay'
        googleGroovyPage.searchField << googleGroovyPage.searchString
        googleGroovyPage.searchField << Keys.TAB

        //In case google privacy checkup is displayed
        if (googleGroovyPage.noThanksButton.isDisplayed()) {
            googleGroovyPage.noThanksButton.click()
        }

        //click on Google Search button
        googleGroovyPage.searchField << Keys.TAB
        googleGroovyPage.searchField << Keys.ENTER

        and: 'search for securePay link and click'
        waitFor { googleGroovyPage.searchWebsite.displayed }
        googleGroovyPage.searchWebsite.click()

        then: 'SecurePay website should be displayed'
        SecurePayHomePage securePayHomePage = waitFor { at SecurePayHomePage}

        when: 'user clicks on Support -> ContactUs'
        securePayHomePage.navigateToMenu(securePayHomePage.supportMenu)

        securePayHomePage.navigateToSubmenu(securePayHomePage.contactUsSubmenu)

        then: 'Contact Us page should be displayed'
        ContactUsPage contactUsPage = waitFor{ at ContactUsPage }

        and: 'user enters data on ContactUs Page'
        contactUsPage.firstName << contactUsPage.randomString()
        contactUsPage.lastName << contactUsPage.randomString()
        contactUsPage.emailAddress << contactUsPage.randomEmail()
        contactUsPage.phoneNumber << contactUsPage.randomPhone()
        contactUsPage.websiteURL << contactUsPage.randomWebsite()
        contactUsPage.companyName << contactUsPage.randomString()
        contactUsPage.reasonEnquirySelect.click()

        and: 'verify all the fields have data'
        assert !contactUsPage.firstName.isEmpty()
        assert !contactUsPage.lastName.isEmpty()
        assert !contactUsPage.emailAddress.isEmpty()
        assert !contactUsPage.phoneNumber.isEmpty()
        assert !contactUsPage.websiteURL.isEmpty()
        assert !contactUsPage.companyName.isEmpty()
        assert contactUsPage.reasonEnquirySelect.value() == 'Support'
    }

}
