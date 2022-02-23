package GameMania.teste;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteLogin {
	//Primeiro, criamos uma variável privada (que só existe aqui nesse projeto) que serve para guardar o webdriver, que vai manipular o navegador.
	private WebDriver driver;
	
	@Before //antes do teste, iremos rodar a função "Setup", que conterá ações anteriores à realização do teste de fato, como abrir o navegador, acessar o site indicado e até a página onde ocorrerá o teste.
	public void Setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver\\chromedriver.exe"); //no sistema, foi definida uma propriedade chamada "webdriver" para o navegador chrome que irá para a variável "driver"; na segunda parte, é indicado o endereço onde ficou salvo o arquivo executável chromedriver.exe em nosso computador.
	
		//para abrir uma nova janela
		driver = new ChromeDriver();
		//para maximizar a janela
		driver.manage().window().maximize();
		//para acessar a página do site onde será feito o teste
		driver.get("http://localhost:4200/loginCadastro");
	
	}
	
	@Test
	public void TestarLogin() {
		//para esperar alguns segundos para esperar a página carregar totalmente antes de iniciar o teste.
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS); //coloquei 7 seg pq meu navegador está muito lento
		
		WebElement inputEmail = driver.findElement(By.id("email")); //criamos a variável do tipo "WebElement", que tem o nome "inputEmail" e ela vai receber o que o navegador encontrar pelo elemento id "email"
		WebElement inputSenha = driver.findElement(By.id("password-example")); //atalho "ctrl + alt + seta para baixo" para duplicar linha
		WebElement botaoLogin = driver.findElement(By.id("botao-enviar"));
		
		//teste com senhas erradas
		//criação de lista de senhas por meio de array
		String[] listaSenhas = {"senhaum", "outrasenhaerrada", "terceirasenhaerrada", "12345678"};
		
		//usaremos a estrutura de repetição "for"
		for (int tentativas = 0; tentativas < listaSenhas.length; tentativas++) {
			
			//estrutura para inserir um tempo de espera entre uma tentativa e outra para termos tempo de verificar o resultado
			try {
				inputEmail.clear(); //para limpar os campos de email e senha para a inserção de novos dados
				inputSenha.clear();
				
				inputEmail.sendKeys("juarez@email.com");
				inputSenha.sendKeys(listaSenhas[tentativas]);
				botaoLogin.click();
				
				Thread.sleep(3000); //para esperar 3 s
			} catch (InterruptedException e) { //caso haja exceção, como interrupção do sistema, o erro será salvo na variável "e" e será "printado" na tela
				e.printStackTrace();
			}
			
			
			
		}
		
		
		//inputEmail.sendKeys("juarez@email.com");
		//inputSenha.sendKeys("12345678");
		//botaoLogin.click(); //ao fazer login com sucesso, há um redirecionamento para a página inicial; quando há erro nos dados, aparece a mensagem "Incorrect password" para senha incorreta e "Cannot find user" para e-mail incorreto.
	}
}














