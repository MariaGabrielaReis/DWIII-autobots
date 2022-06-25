<h1 align="center">
 🚘🛠️ Autobots 🛠️🚘
</h1>

<p align="center">
  <a href="#projeto">Sobre o projeto</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#requisitos">Como rodar</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#demo">Demonstração</a>
</p>

<span id="projeto">
  
# :bookmark_tabs: Sobre o projeto
Este é um sistema para gerenciamento de uma loja de autopeças que consiste em uma API baseada na arquitetura de microsserviço com Java, aplicando conceitos do SOLID e padrões de projeto adequados que possibilitam listagem, cadastro, exclusão e alteração de informações sobre clientes, produtos, serviços, veículos e marcas de veículos.
 
> 💡 Atividade IV: implementar autenticação e autorização via Json Web Token (JWT) para os tipos de usuários presentes no sistema:
> - ✔️ Administrador: pode fazer todas as operações de CRUD (incluindo adicionar ou remover usuários administradores);
> - ✔️ Gerente: acesso ao CRUD de gerentes, vendedores e clientes, bem como sobre serviços, vendas e mercadorias;
> - ✔️ Vendedor: acesso ao CRUD de clientes, criar vendas e ler dados sobre serviços, mercadorias e informações do próprio cadastro;
> - ✔️ Cliente: acesso a informações do próprio cadastro, assim como para vendas em que participou como consumidor.

<span id="requisitos">

# :gear: Como rodar
Para executar o projeto é preciso que o Java e o Git estejam instalados. Para conferir a instalação do Java para Linux, acesse [este tutorial](https://docs.oracle.com/en/java/javase/11/install/installation-jdk-linux-platforms.html#GUID-737A84E4-2EFF-4D38-8E60-3E29D1B884B8), já para Windows acesse [este link](https://docs.oracle.com/en/java/javase/11/install/installation-jdk-microsoft-windows-platforms.html#GUID-A7E27B90-A28D-4237-9383-A58B416071CA). Após os downloads, baixe ou clone este repositório e siga o passo a passo descrito abaixo, pelo terminal:

```bash
# Acesse a pasta do projeto
$ cd DWIII-autobots

# Espere o Maven carregar as dependências do projeto (são listadas no arquivo pom.xml)

# Execute o projeto utilizando sua IDE preferida (Eclipse, VS Code, IntelliJ, etc.)
```

O servidor inciará localmente na porta 8080. Utilize o Insomnia ou o Postman para simular requisições e respostas das rotas (pelo link [https://localhost:8080](https://localhost:8080)).

<span id="demo">
  
# :desktop_computer: Demonstração  
Todas as rotas foram protegidas (excluindo a de criação de usuários), necessitando de autorização para acessar seus recursos, onde esta autorização está ligada diretamente ao cargo que o usuário possui e ao token que o mesmo carrega após sua autenticação no sistema. Além disso, fora as rotas já disponíveis para o gerenciamento de usuários, veículos, produtos, serviços e etc, foi criado também um endpoint para obter os veículos de um usuário específico, imaginando que um mesmo cliente pode ser dono de mais de um veículo e que em alguma aplicação cliente essa informação fosse interessante.

<details>
 <summary>Exemplos de rotas protegidas</summary>
 
 ### CRUD de usuários

| Rotas                    |  Permissões                                                                                                 |
| :----------------------- | :---------------------------------------------------------------------------------------------------------- | 
| ![](https://user-images.githubusercontent.com/69374340/175754422-2c9f95b2-72f8-4e13-a984-088b94980b81.png)  | <ul><li><b>administrador:</b> acesso total; </li><li><b>gerente:</b> acesso total; </li><li><b>funcionário:</b> acesso total; </li><li><b>cliente:</b> lê sobre suas informações, exclui seu registro ou atualizá-o.</li></ul>|
 
 ### CRUD de produtos 
 
| Rotas                    |  Permissões                                                                                                 |
| :----------------------- | :---------------------------------------------------------------------------------------------------------- | 
| ![](https://user-images.githubusercontent.com/69374340/175754677-acfc6624-ac65-403f-9d04-f75bbf48a250.png)  | <ul><li><b>administrador:</b> acesso total; </li><li><b>gerente:</b> acesso total; </li><li><b>funcionário:</b> lê informações sobre todos os produtos, apenas um ou todos os produtos de um determinado tipo; </li><li><b>cliente:</b> lê informações sobre todos os produtos, apenas um ou todos os produtos de um determinado tipo.</li></ul>|
 
 ### CRUD de serviços 
 
| Rotas                    |  Permissões                                                                                                 |
| :----------------------- | :---------------------------------------------------------------------------------------------------------- | 
| ![](https://user-images.githubusercontent.com/69374340/175754741-c68aee08-75f4-4266-b04f-c525d2c35897.png)  | <ul><li><b>administrador:</b> acesso total; </li><li><b>gerente:</b> acesso total; </li><li><b>funcionário:</b> lê informações sobre todos os serviços, apenas um ou todos os serviços de um determinado tipo; </li><li><b>cliente:</b> lê informações sobre todos os serviços, apenas um ou todos os serviços de um determinado tipo.</li></ul>|
 
 ### CRUD de veículos 
 
| Rotas                    |  Permissões                                                                                                 |
| :----------------------- | :---------------------------------------------------------------------------------------------------------- | 
| ![](https://user-images.githubusercontent.com/69374340/175754778-0a1c4fb3-9609-42d2-8d8a-caa65c22e78b.png) | <ul><li><b>administrador:</b> acesso total; </li><li><b>gerente:</b> acesso total; </li><li><b>funcionário:</b> acesso total; </li><li><b>cliente:</b> apenas não pode acessar informações de todos os veículos da base de dados ou estes veículos listados por marca.</li></ul>|
 
 ### CRUD de marca de veículos 
 
| Rotas                    |  Permissões                                                                                                 |
| :----------------------- | :---------------------------------------------------------------------------------------------------------- | 
| ![](https://user-images.githubusercontent.com/69374340/175754835-eba31063-85f1-4154-a1ff-588fc123a9ba.png) | <ul><li><b>administrador:</b> acesso total; </li><li><b>gerente:</b> acesso total; </li><li><b>funcionário:</b> vê todas as marcas cadastradas ou informações de uma única; </li><li><b>cliente:</b> vê todas as marcas cadastradas ou informações de uma única.</li></ul>|
 
 ### CRUD de vendas 
 
| Rotas                    |  Permissões                                                                                                 |
| :----------------------- | :---------------------------------------------------------------------------------------------------------- | 
| ![](https://user-images.githubusercontent.com/69374340/175754896-f036971e-b671-4ce1-ae2b-95f0f43954dd.png) | <ul><li><b>administrador:</b> acesso total; </li><li><b>gerente:</b> acesso total; </li><li><b>funcionário:</b> só não pode acessar todas as vendas realizadas; </li><li><b>cliente:</b> só pode acessar as vendas em que participou ou informações de uma única delas.</li></ul>|
 
 ### CRUD de empresas 
 
| Rotas                    |  Permissões                                                                                                 |
| :----------------------- | :---------------------------------------------------------------------------------------------------------- | 
| ![](https://user-images.githubusercontent.com/69374340/175754949-5cb4e9d5-9639-48e5-a76c-feb5e1f8c58d.png) | <ul><li><b>administrador:</b> acesso total; </li><li><b>gerente:</b> só pode associar usuários, produtos, serviços ou vendas a uma empresa; </li><li><b>funcionário:</b> não tem acesso a nenhuma funcionalidade; </li><li><b>cliente:</b> não tem acesso a nenhuma funcionalidade.</li></ul>|
 
</details>

[![image](https://img.shields.io/badge/✨%20Maria%20Gabriela%20Reis,%202022-LinkedIn-009973?style=flat-square)](https://www.linkedin.com/in/mariagabrielareis/)
