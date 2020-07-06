import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

Map<String, String> ano = new HashMap<String, String>()

Map<String, String> km = new HashMap<String, String>()

Map<String, String> cor = new HashMap<String, String>()

Map<String, String> cambio = new HashMap<String, String>()

Map<String, String> preco = new HashMap<String, String>()

WebUI.callTestCase(findTestCase('consultarCarro'), [:], FailureHandling.STOP_ON_FAILURE)

Integer qtdAnuncio = WebUI.executeJavaScript('return $(".titulo_anuncio").size()', null)

int index = 0

for (int i = 1; i <= 3; i++) {
    WebUI.executeJavaScript(('$(".titulo_anuncio")[' + index) + '].click()', null)

    ano.put('carro' + i, WebUI.getText(findTestObject('div/anoCarro')))

    km.put('carro' + i, WebUI.getText(findTestObject('div/kmCarro')))

    cor.put('carro' + i, WebUI.getText(findTestObject('div/corCarro')))

    cambio.put('carro' + i, WebUI.getText(findTestObject('div/cambioCarro')))

    preco.put('carro' + i, WebUI.getText(findTestObject('div/precoCarro')))

    index++

    WebUI.back()
}

ArrayList <String> newComponentes = new ArrayList<String>()

for(int i = 1; i <=3; i++){
	
	if(i == 1){
		WebUI.verifyElementText(findTestObject('div/anoCarroIndex'), ano.get('carro'+i).replaceAll(" ","").replace("/", "/ "))
		
		WebUI.verifyElementText(findTestObject('div/kmCarroIndex'), km.get('carro'+i))
		
		WebUI.verifyElementText(findTestObject('div/corCarroIndex'), cor.get('carro'+i))
		
		WebUI.verifyElementText(findTestObject('div/cambioCarroIndex'), cambio.get('carro'+i))
	}
	
	if(i==2){
		newComponentes[0] = WebUI.modifyObjectProperty(findTestObject('div/anoCarroIndex'), 'css', 'equals', '#ac29843791 > div > div.clearfix.dados_anuncio > div.dados_veiculo > a > ul > li.primeiro > p', false)
		
		newComponentes[1] = WebUI.modifyObjectProperty(findTestObject('div/kmCarroIndex'), 'css', 'equals', '#ac29843791 > div > div.clearfix.dados_anuncio > div.dados_veiculo > a > ul > li.usado > p', false)
		
		newComponentes[2] = WebUI.modifyObjectProperty(findTestObject('div/corCarroIndex'), 'css', 'equals', '#ac29843791 > div > div.clearfix.dados_anuncio > div.dados_veiculo > a > ul > li:nth-child(3) > p', false)
		
		newComponentes[3] = WebUI.modifyObjectProperty(findTestObject('div/cambioCarroIndex'), 'css', 'equals', '#ac29843791 > div > div.clearfix.dados_anuncio > div.dados_veiculo > a > ul > li.ultimo > p', false)
		
		WebUI.verifyElementText(newComponentes[0], ano.get('carro'+i).replaceAll(" ","").replace("/", "/ "))
		
		WebUI.verifyElementText(newComponentes[1], km.get('carro'+i))
		
		WebUI.verifyElementText(newComponentes[2], cor.get('carro'+i))
		
		WebUI.verifyElementText(newComponentes[3], cambio.get('carro'+i))
	}
	
	if(i == 3){
		newComponentes[4] = WebUI.modifyObjectProperty(findTestObject('div/anoCarroIndex'), 'css', 'equals', '#ac30073843 > div > div.clearfix.dados_anuncio > div.dados_veiculo > a > ul > li.primeiro > p', false)
		
		newComponentes[5] = WebUI.modifyObjectProperty(findTestObject('div/kmCarroIndex'), 'css', 'equals', '#ac30073843 > div > div.clearfix.dados_anuncio > div.dados_veiculo > a > ul > li.usado > p', false)
		
		newComponentes[6] = WebUI.modifyObjectProperty(findTestObject('div/corCarroIndex'), 'css', 'equals', '#ac30073843 > div > div.clearfix.dados_anuncio > div.dados_veiculo > a > ul > li:nth-child(3) > p', false)
		
		newComponentes[7] = WebUI.modifyObjectProperty(findTestObject('div/cambioCarroIndex'), 'css', 'equals', '#ac30073843 > div > div.clearfix.dados_anuncio > div.dados_veiculo > a > ul > li.ultimo > p', false)
		
		WebUI.verifyElementText(newComponentes[4], ano.get('carro'+i).replaceAll(" ","").replace("/", "/ "))
		
		WebUI.verifyElementText(newComponentes[5], km.get('carro'+i))
		
		WebUI.verifyElementText(newComponentes[6], cor.get('carro'+i))
		
		WebUI.verifyElementText(newComponentes[7], cambio.get('carro'+i))
	}
	
}

