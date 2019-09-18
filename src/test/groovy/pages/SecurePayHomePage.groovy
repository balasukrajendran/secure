package pages

import geb.Page
import geb.navigator.Navigator

class SecurePayHomePage extends Page {
    static at = { heading.displayed }

    static content = {
        heading { $('h1', text: 'Powering online payments for Australian businesses')}
        supportMenu { $(id:'menu-item-3367') }
        contactUsSubmenu (required:false) { $(id:'menu-item-179') }
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

}
