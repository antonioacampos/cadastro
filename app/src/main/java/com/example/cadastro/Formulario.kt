package com.example.cadastro

data class Formulario(
    var nome: String,
    var telefone: String,
    var email: String,
    var emailList: Boolean,
    var sexo: String,
    var cidade: String,
    var uf: String
) {
    override fun toString(): String {
        return "Nome: $nome\nTelefone: $telefone\nEmail: $email\nIngressar na lista de e-mails: $emailList\nSexo: $sexo\nCidade: $cidade\nUF: $uf"
    }
}