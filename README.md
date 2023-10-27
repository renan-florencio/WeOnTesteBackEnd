# WeOnTesteBackEnd

###Teste de conhecimento back-end - v2.0

O projeto é um monolito que instancias algumas threads de consumo e produção de mensagens. 
A mesma conta com a persistência das mensagens no banco de dados e adição em uma fila FIFO.
A fila FIFO é consumida e o objeto presente nela removido do Banco de dados após o consumo do mesmo.

------------------------------------------------------------

###Dependências do projeto

`Build`
*	hibernate-core: 6.3.1-Final
*	jackson-dataformat-yaml: 2.15.3
*	jackson-datatype-jsr310: 2.15.3

`Teste`

*	h2: 2.2.224
*	junit-jupiter-api: 5.10.0

`Runtime`
*	postgresql driver

------------------------------------------------------------

###Configuração

A configuração do projeto é realizada através do arquivo config.yaml

`config.yaml`
* consumidores: 2 - Numero de instancias do consumidor
* produtores_voz: 3 - Numero de instancias de produtor voz
* produtores_email: 3 - Numero de instancias de produtor email
* produtores_chat: 3 - Numero de instancias de produtor chat
* produtores_timeout: 10 - Timeout de produção de objetos
* DB: - Configuração de database
* - driver: org.h2.Driver - Driver
*   url: jdbc:h2:mem:test - String de conexão
*   hibernate_dialect: org.hibernate.dialect.H2Dialect - hibernate dialect (Configuração do dialeto usado para criação dos comandos SQL)
*   hibernate_hbm2ddl_auto: create-drop - Utilizado para definir como será o funcionamento dos ddl's na subida da aplicação
*   usuario: sa - Usuário de acesso ao database
*   senha: "" - Senha de acesso ao database
