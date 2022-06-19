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
 
> 💡 Atividade III: implementar CRUD para usuários, veículos, serviços, peças e vendas, com total autonomia de desenvolvedor chefe, porém algumas funcionalidades acodadas são imprescindíveis:
> - ✔️ cadastro deempresa (unidade comercial que oferece o serviço de manutenção e venda de mercadorias);
> - ✔️ associação de usuários a uma determinada empresa;
> - ✔️ tipos de usuários no sistema com "cliente", "fornecedor" e "funcionário" 
> - ✔️ inclusão de credencial para acesso de um usuário ao sistema
 
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
## :railway_track: Rotas disponíveis para operações de gerenciamento

<details>
 <summary>Endpoints disponíveis para gerenciamento de <b>Usuários</b></summary>
 <br>
<div align="center">
 
| Situação                 |  Resultado                 |
| :----------------------- | :------------------------- | 
| Novo cliente             | ![](https://user-images.githubusercontent.com/69374340/174503668-75c77c8a-9a8d-4e0f-b177-290ad977d7e7.png) |
| Novo funcionário         | ![](https://user-images.githubusercontent.com/69374340/174503706-4438e66e-a373-4778-af65-819ffaa2c372.png) |
| Todos os usuários        | ![](https://user-images.githubusercontent.com/69374340/174503750-3d13dc7e-a274-4db2-9e93-a5a5ca2b81b6.png) |
| Todos os clientes        | ![](https://user-images.githubusercontent.com/69374340/174503769-b77e03f0-bddb-4fbd-b1ee-d9d4e7e1cd86.png) |
| Todos os funcionários    | ![](https://user-images.githubusercontent.com/69374340/174503780-2b973f0c-cecd-43ad-8aa2-39f6113abce8.png) |
| Usuário específico       | ![](https://user-images.githubusercontent.com/69374340/174503812-fb98024e-b5a7-4c44-ad78-6e8c714f5412.png) |
| Alterar dados de usuário | ![](https://user-images.githubusercontent.com/69374340/174503832-f565ebc3-3703-44b4-9979-8921c86ba712.png) |
| Excluir usuário          | ![](https://user-images.githubusercontent.com/69374340/174503846-91118942-afc1-47be-96cb-b2e7338ab47b.png) |
</div>
</details>
 
<details>
 <summary>Endpoints disponíveis para gerenciamento de <b>Marcas de Veículos</b></summary>
 <br>
<div align="center">
 
| Situação              |  Resultado                 |
| :-------------------- | :------------------------- | 
| Nova marca            | ![]() |
| Todas as marcas       | ![]() |
| Marca específica      | ![]() |
| Alterar nome de marca | ![]() |
| Excluir marca         | ![]() |
</div>
</details>
 
<details>
 <summary>Endpoints disponíveis para gerenciamento de <b>Veículos</b></summary>
 <br>
<div align="center">
 
| Situação                         |  Resultado                 |
| :------------------------------- | :------------------------- | 
| Novo veículo                     | ![]() |
| Todos os veículos                | ![]() |
| Veículo específico               | ![]() |
| Alterar quilometragem de veículo | ![]() |
| Excluir veículo                  | ![]() |
</div>
</details>
 
<details>
 <summary>Endpoints disponíveis para gerenciamento de <b>Produtos</b></summary>
 <br>
<div align="center">
 
| Situação                     |  Resultado                 |
| :--------------------------- | :------------------------- | 
| Novo produto                 | ![]() |
| Todos os produtos            | ![]() |
| Todos os produtos de um tipo | ![]() |
| Produto específico           | ![]() |
| Alterar nome de produto      | ![]() |
| Excluir produto              | ![]() |
</div>
</details>
 
<details>
 <summary>Endpoints disponíveis para gerenciamento de <b>Serviços</b></summary>
 <br>
<div align="center">
 
| Situação                     |  Resultado                 |
| :--------------------------- | :------------------------- | 
| Novo serviço                 | ![]() |
| Todos os serviços            | ![]() |
| Todos os serviços de um tipo | ![]() |
| Serviço específico           | ![]() |
| Alterar nome de serviço      | ![]() |
| Excluir serviço              | ![]() |
</div>
</details>
 
<details>
 <summary>Endpoints disponíveis para gerenciamento de <b>Vendas</b></summary>
 <br>
<div align="center">
 
| Situação                                    |  Resultado                 |
| :------------------------------------------ | :------------------------- | 
| Nova venda                                  | ![]() |
| Todas as vendas                             | ![]() |
| Todos as vendas que um funcionário realizou | ![]() |
| Todos as vendas que um cliente realizou     | ![]() |
| Venda específica                            | ![]() |
</div>
</details>
 
<details>
 <summary>Endpoints disponíveis para gerenciamento de <b>Empresas</b></summary>
 <br>
<div align="center">
 
| Situação                       |  Resultado                 |
| :----------------------------- | :------------------------- | 
| Nova empresa                   | ![]() |
| Todas as empresas              | ![]() |
| Empresa específica             | ![]() |
| Associar usuário a uma empresa | ![]() |
| Associar produto a uma empresa | ![]() |
| Associar serviço a uma empresa | ![]() |
| Associar venda a uma empresa   | ![]() |
| Alterar nome de empresa        | ![]() |
| Excluir empresa                | ![]() |
</div>
</details>

[![image](https://img.shields.io/badge/✨%20Maria%20Gabriela%20Reis,%202022-LinkedIn-009973?style=flat-square)](https://www.linkedin.com/in/mariagabrielareis/)
