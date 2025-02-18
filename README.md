# Adopet - Sistema de Adoção de Animais

Adopet é uma aplicação web voltada para facilitar a adoção de animais, permitindo que tutores, abrigos e administradores gerenciem de forma eficiente a adoção de animais. O sistema oferece funcionalidades como cadastro de tutores, animais, abrigos e autenticação de usuários com diferentes tipos de permissões.

## Funcionalidades

- **Cadastro e Autenticação de Usuários**:
  - Usuários podem se registrar e fazer login com diferentes tipos de permissões (Tutor, Administrador, etc).
  
- **Gerenciamento de Tutores**:
  - **Tutores** podem ser cadastrados, atualizados ou excluídos.
  - Restrição de acesso: **somente administradores** podem gerenciar os tutores.

- **Gerenciamento de Animais**:
  - Animais podem ser cadastrados, atualizados, listados e excluídos pelos abrigos.
  - **Tutores** podem ver a lista de animais disponíveis para adoção.

- **Gerenciamento de Abrigos**:
  - **Abrigos** podem ser cadastrados, atualizados ou excluídos.
  - **Tutores** podem visualizar e fazer adoções a partir dos abrigos cadastrados.

- **Sistema de Autenticação**:
  - Utiliza autenticação JWT para garantir que apenas usuários autenticados acessem as funcionalidades do sistema.
  - **Tutores** não podem acessar funcionalidades específicas de gerenciar outros tutores.

## Tecnologias Utilizadas

- **Backend**:
  - **Spring Boot** - Framework Java para desenvolvimento do backend.
  - **Spring Security** - Implementação de segurança e autenticação.
  - **JWT (JSON Web Tokens)** - Para autenticação de usuários e controle de permissões.
  - **JPA (Java Persistence API)** - Para manipulação de dados no banco de dados.
  - **BCrypt** - Para criptografar senhas dos usuários.

- **Banco de Dados**:
  - **PostgreSQL** - Banco de dados relacional para armazenar informações.
  
### Endpoints
## Usuários
<br>
POST /login/auth - Realiza o login do usuário e retorna o token JWT.
<br>
POST /login/registrar - Registra um novo usuário (tutor).
<br>

## Tutores
GET /Tutores/Buscar - Lista todos os tutores cadastrados (restrito para administradores).
<br>

![Image](https://github.com/user-attachments/assets/1a3c866c-8eed-4a16-b0da-f553c802a8d9)
<br>
POST /Tutores - Cria um novo tutor (restrito para administradores).
<br>

![Image](https://github.com/user-attachments/assets/8427d750-7a19-4b32-8618-a17c344b14dc)
<br>
PUT /Tutores/Atualizar/{id} - Atualiza os dados de um tutor (restrito para administradores).
<br>

![Image](https://github.com/user-attachments/assets/574bb6aa-81f0-4eb5-963f-e94b8c3d2932)
<br>

DELETE /Tutores/Deletar/{id} - Deleta um tutor (restrito para administradores).
<br>

![Image](https://github.com/user-attachments/assets/545d2639-acb4-43e8-9e34-8606f7e94163)
<br>

## Animais
GET /Animais - Lista todos os animais cadastrados.
<br>

![Image](https://github.com/user-attachments/assets/0e9e4b70-97e2-40ed-953f-cb6704d67d73)
<br>
GET /Animais/{id} - Busca um animal específico por ID.
<br>

![Image](https://github.com/user-attachments/assets/e724175e-b0b2-4849-a140-c9f25db39059)
<br>
POST /Animais - Cria um novo animal (restrito para abrigos).
<br>

![Image](https://github.com/user-attachments/assets/ebd93f1d-e711-4275-b4d4-d6f105c8982a)
<br>
PUT /Animais/{id} - Atualiza os dados de um animal (restrito para abrigos).
<br>

![Image](https://github.com/user-attachments/assets/604a4314-bf2b-4a23-8a70-2dc405a91bab)
<br>
DELETE /Animais/{id} - Deleta um animal (restrito para abrigos).
<br>

![Image](https://github.com/user-attachments/assets/3214b344-38d0-4c44-94de-9f35ccc919b8)
<br>

## Abrigos
GET /Abrigo - Lista todos os abrigos cadastrados.
<br>

![Image](https://github.com/user-attachments/assets/d32f2de5-1b0e-44d2-9a87-4affa4e972aa)
<br>
POST /Abrigo/adicionar - Cria um novo abrigo.
<br>

![Image](https://github.com/user-attachments/assets/d9998986-5869-4021-9147-c7446341683c)
<br>
PUT /Abrigo/{id} - Atualiza os dados de um abrigo.
<br>

![Image](https://github.com/user-attachments/assets/c12f38c6-9fed-4986-baca-1ecaf4cdbf5c)
<br>

DELETE /Abrigo/{id} - Deleta um abrigo.
<br>

![Image](https://github.com/user-attachments/assets/406067e0-bb8c-4aeb-8c22-d4ef599f8054)
<br>

### Restrições de Acesso
Tutores têm permissões limitadas a visualizar e adotar animais.
Administradores podem gerenciar os tutores, animais e abrigos.
A autenticação é feita via JWT, e a autorização é gerenciada pelas roles atribuídas aos usuários.

