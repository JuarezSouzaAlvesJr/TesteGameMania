package GameMania.teste;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteLogin {
	//Primeiro, criamos uma vari�vel privada (que s� existe aqui nesse projeto) que serve para guardar o webdriver, que vai manipular o navegador.
	private WebDriver driver;
	
	@Before //antes do teste, iremos rodar a fun��o "Setup", que conter� a��es anteriores � realiza��o do teste de fato, como abrir o navegador, acessar o site indicado e at� a p�gina onde ocorrer� o teste.
	public void Setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver\\chromedriver.exe"); //no sistema, foi definida uma propriedade chamada "webdriver" para o navegador chrome que ir� para a vari�vel "driver"; na segunda parte, � indicado o endere�o onde ficou salvo o arquivo execut�vel chromedriver.exe em nosso computador.
	
		//para abrir uma nova janela
		driver = new ChromeDriver();
		//para maximizar a janela
		driver.manage().window().maximize();
		//para acessar a p�gina do site onde ser� feito o teste
		driver.get("http://localhost:4200/loginCadastro");
	
	}
	
	@Test
	public void TestarLogin() {
		//para esperar alguns segundos para esperar a p�gina carregar totalmente antes de iniciar o teste.
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS); //coloquei 7 seg pq meu navegador est� muito lento
		
		WebElement inputEmail = driver.findElement(By.id("email")); //criamos a vari�vel do tipo "WebElement", que tem o nome "inputEmail" e ela vai receber o que o navegador encontrar pelo elemento id "email"
		WebElement inputSenha = driver.findElement(By.id("password-example")); //atalho "ctrl + alt + seta para baixo" para duplicar linha
		WebElement botaoLogin = driver.findElement(By.id("botao-enviar"));
		
		//teste com senhas erradas
		//cria��o de lista de senhas por meio de array
		String[] listaSenhas = {"senhaum", "outrasenhaerrada", "terceirasenhaerrada", "12345678"};
		
		//usaremos a estrutura de repeti��o "for"
		for (int tentativas = 0; tentativas < listaSenhas.length; tentativas++) {
			
			//estrutura para inserir um tempo de espera entre uma tentativa e outra para termos tempo de verificar o resultado
			try {
				inputEmail.clear(); //para limpar os campos de email e senha para a inser��o de novos dados
				inputSenha.clear();
				
				inputEmail.sendKeys("juarez@email.com");
				inputSenha.sendKeys(listaSenhas[tentativas]);
				botaoLogin.click();
				
				Thread.sleep(3000); //para esperar 3 s
			} catch (InterruptedException e) { //caso haja exce��o, como interrup��o do sistema, o erro ser� salvo na vari�vel "e" e ser� "printado" na tela
				e.printStackTrace();
			}
			
			
			
		}
		
		
		//inputEmail.sendKeys("juarez@email.com");
		//inputSenha.sendKeys("12345678");
		//botaoLogin.click(); //ao fazer login com sucesso, h� um redirecionamento para a p�gina inicial; quando h� erro nos dados, aparece a mensagem "Incorrect password" para senha incorreta e "Cannot find user" para e-mail incorreto.
	}
}














