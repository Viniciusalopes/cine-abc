## Pacotes de camadas

### app - Application (ou UI:User Interface)

- Camada de Aplicação ou Interface

Este pacote contém as classes responsáveis por apresentar ao usuário o resultado final de 
todo o processamento do sistema que se comunica somente com a BLL, não fazendo acesso 
direto à DAO.

---

### bll - Business Logic Layer

- Camada de Regra de negócios

Este pacote contém as classes responsáveis por possuir as regras especificas do sistema a 
ser desenvolvido, sendo responsável por se comunicar com a DAO (para acessar os dados 
retornados do banco) e fornecer informações à UI (para repassar o resultado do 
processamento e configuração das regras do sistema).

---

### dao - Data Access Object 

- Camada de Acesso a Dados

Camada responsável se conectar e fazer todas as transações referentes a banco de dados
como consultas, inserções de dados, atualizações de dados e exclusão de dados. Essa camada
faz a comunicação com a BLL, não se comunicando diretamente com a UI.

---

### model - Modelos

- Camada de Modelos de Dados

Camada responsável por estabelecer o modelo do objeto de dados, e fornecer objetos para
manipulação nas outras camadas. 

---

### util - Utilitários

- Camada de Utilidades e Utilitários

Camada responsável por métodos que sejam úteis ao funcionamento das outras camadas e que 
não se enquadrem nas características de nenhuma delas.

---

FONTE: https://www.devmedia.com.br/visao-geral-do-desenvolvimento-em-camadas-trabalhando-com-desenvolvimento-em-camadas-utilizando-csharp/21645
