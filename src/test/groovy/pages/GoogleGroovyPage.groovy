package pages

import geb.Page
import geb.navigator.Navigator

class GoogleGroovyPage extends Page {


    static at = { title == 'Google' }

    static content = {
        searchField { $('input', name: 'q', title: 'Search') }
        searchButton { $('input', value:'Google Search',type:'submit',0) }
        searchWebsite { $('a',id:'vn1s0p1c0').find('h3') }
        noThanksButton (required:false) { $( 'a', role:'button', text:'No, thanks')}

    }

    def navigateToMenu(Navigator menu) {
        waitFor(30) { menu.displayed }
        interact {
            moveToElement(menu)
        }
        true
    }

    def navigateToSubmenu(Navigator submenu) {
        waitFor(30) { submenu.displayed }
        submenu.click()
        true
    }

    def searchString = 'SecurePay'

}
