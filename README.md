# WeOnTesteBackEnd

###Teste de conhecimento back-end - v1.0

O projeto é um monolito que instancias algumas threads de consumo e produção de mensagens. 
A mesma conta com a persistência das mensagens no banco de dados.


------------------------------------------------------------

###Dependências do projeto

`Build`
*	hibernate-core: 6.3.1-Final

`Teste`

*	h2: 2.2.224
*	junit-jupiter-api: 5.10.0

`Runtime`
*	postgresql driver

------------------------------------------------------------

###Configuração

A configuração do projeto é dividida em duas partes: application.properties e persistence.xml

`application.properties - Configuração da aplicação`
*	consumers.instances - Recebe um número que define a quantidade de instâncias da consumer.
*	producers.voice.instances - Recebe um número que define a quantidade de instâncias da producer voice.
*	producers.email.instances - Recebe um número que define a quantidade de instâncias da producer email.
*	producers.chat.instances - Recebe um número que define a quantidade de instâncias da producer chat.
*	producers.timeout - Recebe um número que define o timeout das producers.

`persistence.xml - Configuração de persistência de dados`
*	jakarta.persistence.jdbc.url - String de conexão para o banco de dados
*	jakarta.persistence.jdbc.user - Usuário para acesso ao banco de dados
*	jakarta.persistence.jdbc.password - Senha de acesso do usuário

