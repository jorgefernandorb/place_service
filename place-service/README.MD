Place Service
    Tecnologias
        Spring Boot
        Spring Webflux
        Spring Data + R2DBC
        SpringDoc OpenAPI 3
        Slugify
    Práticas Adotadas
SOLID: Princípios de design de software para manter a modularidade e a facilidade de manutenção.
Testes Automatizados: Implementação de testes para garantir a funcionalidade correta e a integridade do código.
Consultas com Filtros Dinâmicos: Uso do Query By Example para permitir consultas flexíveis e dinâmicas.
API Reativa: Implementação de uma API reativa tanto na camada web quanto na camada de banco de dados.
Uso de DTOs: Utilização de Data Transfer Objects (DTOs) para expor apenas as propriedades necessárias na API.
Injeção de Dependências: Utilização de injeção de dependências para promover a modularidade e o desacoplamento.
Geração Automática do Swagger: Documentação da API gerada automaticamente com OpenAPI 3.
Geração de Slugs Automática: Utilização da biblioteca Slugify para criar slugs baseados nos nomes.
Auditoria: Implementação de auditoria para rastrear a criação e atualização das entidades.
Como Executar
Localmente
Clone o repositório Git:

bash
Copiar código
git clone <url-do-repositorio>
Construa o projeto:

bash
Copiar código
./mvnw clean package
Execute o projeto:

bash
Copiar código
java -jar place-service/target/place-service-0.0.1-SNAPSHOT.jar
A API estará disponível em localhost:8080. O Swagger pode ser visualizado em localhost:8080/swagger-ui.html.

Usando Docker
Clone o repositório Git:

bash
Copiar código
git clone <url-do-repositorio>
Construa o projeto:

bash
Copiar código
./mvnw clean package
Construa a imagem Docker:

bash
Copiar código
./mvnw spring-boot:build-image
Execute o container:

bash
Copiar código
docker run --name place-service -p 8080:8080 -d place-service:0.0.1-SNAPSHOT
A API estará disponível em localhost:8080. O Swagger pode ser visualizado em localhost:8080/swagger-ui.html.

API Endpoints
Para fazer as requisições HTTP abaixo, utilize a ferramenta httpie:

POST /places

bash
Copiar código
http POST :8080/places name="Place" state="State"
Resposta esperada:

json
Copiar código
HTTP/1.1 200 OK
Content-Length: 129
Content-Type: application/json

{
    "createdAt": "2024-08-20T19:00:07.241632",
    "name": "Place",
    "slug": "place",
    "state": "State",
    "updatedAt": "2028-08-20T19:00:07.241632"
}
Observações
O atributo id é gerado automaticamente pelo banco de dados com auto incremento.
A utilização de DTOs permite expor apenas as propriedades necessárias da entidade Place, evitando a exposição direta dos objetos de domínio.
A biblioteca slugify é utilizada para garantir a consistência entre o nome e o slug.