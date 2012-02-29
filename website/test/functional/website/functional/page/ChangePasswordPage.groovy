package website.functional.page

import geb.Page

/**
 * Created by IntelliJ IDEA.
 * User: Nico
 * Date: 07/07/11
 * Time: 15:20
 * To change this template use File | Settings | File Templates.
 */
class ChangePasswordPage extends Page {
    static url = '/misc/register/changePassword'

    static at = {
        waitFor { $('#changePasswordPage').displayed }
	}

    static content = {
        changePasswordForm (required:true) {$('#changePasswordForm')}
        changeSubmitButton (required:true) { $('#changePasswordSubmit') }
    }

    def changePassword(String oldPassword, String newPassword) {
		changePasswordForm.oldPassword = oldPassword
		changePasswordForm.password = newPassword
        changePasswordForm.password2 = newPassword
		changeSubmitButton.click()
	}
}
