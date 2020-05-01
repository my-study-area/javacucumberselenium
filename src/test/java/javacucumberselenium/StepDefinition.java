package javacucumberselenium;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.hamcrest.CoreMatchers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class StepDefinition {
	static final Logger LOGGER = Logger.getLogger(StepDefinition.class.getName());

	WebDriver wd = null;

	@Before
	public void beforeScenario(){
		LOGGER.info("Inicia conexão com o navegador");
		wd = getDriver();
	}

	@Dado("que eu sou um usuário cadastrado")
	public void que_eu_sou_um_usuário_cadastrado() {
		LOGGER.info("cria um usuário no banco de dados...");
	}

	@Dado("visito a página de login")
	public void visito_a_página_de_login() {
		LOGGER.info("visita a página fde login...");
		wd.get("http://localhost:3000/users/sign_in");
	}

	@Quando("preencher o campo email com {string}")
	public void preencher_o_campo_email_com(String email) {
		WebElement emailField = wd.findElement(By.id("user_email"));
		emailField.sendKeys(email);
	}

	@Quando("preencher o campo senha com {string}")
	public void preencher_o_campo_senha_com(String senha) {
		WebElement passwordField = wd.findElement(By.id("user_password"));
		passwordField.sendKeys(senha);
	}

	@Quando("clicar no botão Entrar")
	public void clicar_no_botão_Entrar() {
		wd.findElement(By.cssSelector("input[type='submit']")).click();
	}

	@Então("eu devo ter acesso ao sistema")
	public void eu_devo_ter_acesso_ao_sistema() {
		String title = wd.findElement(By.className("navbar-left")).getText();
		assertThat("Sistema de certificados", CoreMatchers.containsString(title));
	}

	@Dado("que eu não sou um usuário cadastrado")
	public void que_eu_não_sou_um_usuário_cadastrado() {
		LOGGER.info("Usuário não está cadastrado");
	}

	@Então("eu devo ver uma mensagem de {string}")
	public void eu_devo_ver_uma_mensagem_de(String expectedMessage) {
		LOGGER.info("Exibe mensagem de erro.");
		String message = wd.findElement(By.cssSelector(".alert-danger")).getText();
		assertThat(message, CoreMatchers.containsString(expectedMessage));
//		Assert.assertEquals("igual", message, expectedMessage);
	}


	@After
	public void afterScenario(){
		LOGGER.info("fecha a conexão com o navegador");
		wd.close();
	}

	public WebDriver getDriver() {
		WebDriver driver = null;
		System.setProperty("webdriver.gecko.driver","/home/adriano/workspace-neon-2/geckodriver");
		System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true");
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");

		//configura Headless mode (sem abrir browser)
		FirefoxOptions options = new FirefoxOptions();
		options.setHeadless(true);
//		driver =  new FirefoxDriver(options);

		//abrindo navegador
		driver =  new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
}
