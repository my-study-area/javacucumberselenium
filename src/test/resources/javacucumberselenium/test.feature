# language:pt
@autenticar
Funcionalidade: Autenticação de usuários
	Como usuário do sistema
	Eu quero realizar a autenticação
	Para ter acesso ao sistema

	Cenário: Usuário realiza o login
		Dado que eu sou um usuário cadastrado
		E visito a página de login
		Quando preencher o campo email com "delete@delete.com"
		E preencher o campo senha com "123123123"
		E clicar no botão Entrar
		Então eu devo ter acesso ao sistema

	Cenário: Usuário realiza o login com informações inválidas
		Dado que eu não sou um usuário cadastrado
		E visito a página de login
		Quando preencher o campo email com "invalid@invalid.com"
		E preencher o campo senha com "123123123"
		E clicar no botão Entrar
		Então eu devo ver uma mensagem de "Email ou senha inválida."
