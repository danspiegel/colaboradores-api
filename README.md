## Arquivo Leia-Me

## Repositório (GitHub)

## URLs dos Serviços

Inserir Colaborador: localhost:8080/colaborador/inserirColaborador

Parâmetro Exemplo: 

{
	"cpf": "12345678912",
	"nome": "João",
	"idade": 25,
	"telefone": "995959696",
	"email": "joao@gmail.com",
	"setor": {
		"id": 1
	}
}

Obs.: Somente o CPF, nome, idade, telefone e e-mail são obrigatórios.

Buscar Colaborador Por Id: localhost:8080/colaborador/buscarColaboradorPorId/{id}

Remover Colaborador Por Id: localhost:8080/colaborador/removerColaborador/{id}

Listar Colaboradores Agrupados Por Setor: localhost:8080/setor/listarColaboradoresPorSetor

## Script SQL de Criação do Banco e Insert de Setores

- https://github.com/danspiegel/colaboradores-api/blob/master/src/main/resources/sql/script.sql

