package pages

import geb.Page
import org.apache.commons.lang.RandomStringUtils

class ContactUsPage extends Page{

    static at = { heading.displayed }

    static content = {
        heading { $('h1', text: 'Contact us')}

        firstName { $('input', name: 'first-name') }
        lastName { $('input', name: 'last-name') }
        emailAddress { $('input', name: 'email-address') }
        phoneNumber { $('input', name: 'phone-number') }
        websiteURL { $('input', name: 'website-url') }
        companyName { $('input', name: 'business-name') }
        reasonEnquirySelect { $('select', name:'reason-for-enquiry').find('option',value:'Support') }
    }

    static randomString() {
        String charset = (('a'..'z') + ('A'..'Z')).join()
        RandomStringUtils.random(5, charset.toCharArray())
    }

    static randomEmail() {
        String charset = (('a'..'z') + ('A'..'Z')).join()
        RandomStringUtils.random(5, charset.toCharArray()) + '@test.com'
    }

    static randomPhone() {
        String charset =  (('0'..'9')).join()
        RandomStringUtils.random(10, charset.toCharArray())
    }

    static randomWebsite() {
        String charset = (('a'..'z') + ('A'..'Z')).join()
        'www.' + RandomStringUtils.random(5, charset.toCharArray()) + '.exampledomain.com'
    }

}
