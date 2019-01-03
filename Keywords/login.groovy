
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.awt.List
import java.awt.Desktop.Action

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException


class login {
	/**
	 * Refresh browser
	 */
	@Keyword
	def refreshBrowser() {
		KeywordUtil.logInfo("Refreshing")
		WebDriver webDriver = DriverFactory.getWebDriver()
		webDriver.navigate().refresh()
		KeywordUtil.markPassed("Refresh successfully")
	}

	/**
	 * Click element
	 * @param to Katalon test object
	 */
	@Keyword
	def clickElement(TestObject to) {
		try {
			WebElement element = WebUiBuiltInKeywords.findWebElement(to);
			KeywordUtil.logInfo("Clicking element")
			element.click()
			KeywordUtil.markPassed("Element has been clicked")
		} catch (WebElementNotFoundException e) {
			KeywordUtil.markFailed("Element not found")
		} catch (Exception e) {
			KeywordUtil.markFailed("Fail to click on element")
		}
	}

	/**
	 * Get all rows of HTML table
	 * @param table Katalon test object represent for HTML table
	 * @param outerTagName outer tag name of TR tag, usually is TBODY
	 * @return All rows inside HTML table
	 */
	/*@Keyword
	 def List<WebElement> getHtmlTableRows(TestObject table, String outerTagName) {
	 WebElement mailList = WebUiBuiltInKeywords.findWebElement(table)
	 List<WebElement> selectedRows = mailList.findElements(By.xpath("./" + outerTagName + "/tr"))
	 return selectedRows
	 }*/
	@Keyword
	def loginM(String url,String user,String password){

		WebUI.openBrowser(url)
		WebUI.maximizeWindow()

		WebUI.delay(3)

		WebUI.click(findTestObject('Object Repository/login/clickOnLogo'))
		WebUI.delay(3)

		WebUI.click(findTestObject('Object Repository/login/clickLogin'))
		WebUI.delay(3)

		WebUI.click(findTestObject('Object Repository/login/clickGoogle'))
		WebUI.delay(3)

		WebUI.switchToWindowIndex(1)
		WebUI.delay(3)

		WebUI.sendKeys(findTestObject('Object Repository/login/clickEmail'),user)
		WebUI.delay(3)

		WebUI.click(findTestObject('Object Repository/login/clickNext'))

		WebUI.switchToWindowIndex(1)
		WebUI.delay(3)

		WebUI.sendKeys(findTestObject('Object Repository/login/clickEmail'),password)
		WebUI.delay(3)

		WebUI.click(findTestObject('Object Repository/login/clickNext'))

		WebUI.delay(5)

		WebUI.switchToDefaultContent()
	}

	@Keyword
	def casualShirt(String casual){
		WebUI.delay(4)
		WebUI.mouseOver(findTestObject('Object Repository/CasualShirt/clickMan'))
		WebUI.delay(2)

		WebUI.click(findTestObject('Object Repository/CasualShirt/clickCasual'))
		WebUI.delay(2)

		WebUI.sendKeys(findTestObject('Object Repository/CasualShirt/clickSearch'), casual)
		WebUI.click(findTestObject('Object Repository/CasualShirt/searchIcon'))
		WebUI.delay(2)

		WebUI.mouseOver(findTestObject('Object Repository/CasualShirt/over1stItem'))

		WebUI.click(findTestObject('Object Repository/CasualShirt/addBag'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/CasualShirt/selectSize'))

		WebUI.click(findTestObject('Object Repository/CasualShirt/gotoBag'))
		WebUI.delay(4)

		/*String product=WebUI.getText(findTestObject('Object Repository/CasualShirt/bagItemCasual'))
		 if(produt ==  casual)
		 println 'smae item is present in the bag'
		 else
		 println 'different item present in bag'*/

		WebUI.click(findTestObject('Object Repository/goToHome'))
	}


	@Keyword
	def formalShirt(String formal){
		WebUI.mouseOver(findTestObject('Object Repository/CasualShirt/clickMan'))
		WebUI.delay(2)

		WebUI.click(findTestObject('Object Repository/formal/selectFormal'))
		WebUI.delay(2)

		WebUI.sendKeys(findTestObject('Object Repository/CasualShirt/clickSearch'), formal)
		WebUI.click(findTestObject('Object Repository/CasualShirt/searchIcon'))
		WebUI.delay(2)

		WebUI.mouseOver(findTestObject('Object Repository/CasualShirt/over1stItem'))

		WebUI.click(findTestObject('Object Repository/CasualShirt/addBag'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/CasualShirt/selectSize'))

		WebUI.click(findTestObject('Object Repository/CasualShirt/gotoBag'))
		WebUI.delay(4)

		/*String product=WebUI.getText(findTestObject('Object Repository/CasualShirt/bagItemCasual'))
		 if(produt ==  formal)
		 println 'smae item is present in the bag'
		 else
		 println 'different item present in bag'*/
	}



	@Keyword
	def coutBagItem(){
		WebDriver driver=DriverFactory.getWebDriver()
		List<WebElement> temp=driver.findElements(By.xpath("(//a[@class='itemContainer-base-itemLink'])"))
	int count=temp.size
		println count
	}

	@Keyword

	def logout(){
		WebUI.click(findTestObject('Object Repository/goToHome'))
		WebUI.delay(3)

		WebUI.click(findTestObject('Object Repository/login/clickOnLogo'))
		WebUI.delay(3)

		WebUI.click(findTestObject('Object Repository/logout/clickLogout'))
		WebUI.delay(5)
	}
}