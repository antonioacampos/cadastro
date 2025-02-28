package com.example.cadastro

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var titulo: TextView
    private lateinit var nome: EditText
    private lateinit var telefone: EditText
    private lateinit var email: EditText
    private lateinit var emailList: CheckBox
    private lateinit var sexo: TextView
    private lateinit var radioSexo: RadioGroup
    private lateinit var masculino: RadioButton
    private lateinit var feminino: RadioButton
    private lateinit var cidade: EditText
    private lateinit var uf: Spinner
    private lateinit var btnLimpar: Button
    private lateinit var btnSalvar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        titulo = findViewById(R.id.titulo)
        nome = findViewById(R.id.nome)
        telefone = findViewById(R.id.telefone)
        email = findViewById(R.id.email)
        emailList = findViewById(R.id.emailList)
        sexo = findViewById(R.id.sexo)
        radioSexo = findViewById(R.id.radioSexo)
        masculino = findViewById(R.id.masculino)
        feminino = findViewById(R.id.feminino)
        cidade = findViewById(R.id.cidade)
        uf = findViewById(R.id.uf)

        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.ufs,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        uf.adapter = adapter

        btnLimpar = findViewById(R.id.btnLimpar)
        btnSalvar = findViewById(R.id.btnSalvar)

        btnLimpar.setOnClickListener { limparCampos() }
        btnSalvar.setOnClickListener { salvarDados() }
    }

    private fun limparCampos() {
        nome.text.clear()
        telefone.text.clear()
        email.text.clear()
        emailList.isChecked = false
        radioSexo.clearCheck()
        cidade.text.clear()
        uf.setSelection(0)
    }

    private fun salvarDados() {
        val nomeValor = nome.text.toString().takeIf { it.isNotEmpty() } ?: "Nome não fornecido"
        val telefoneValor = telefone.text.toString().takeIf { it.isNotEmpty() } ?: "Telefone não fornecido"
        val emailValor = email.text.toString().takeIf { it.isNotEmpty() } ?: "Email não fornecido"
        val emailListValor = emailList.isChecked
        val sexoValor = if (masculino.isChecked) "Masculino" else "Feminino"
        val cidadeValor = cidade.text.toString().takeIf { it.isNotEmpty() } ?: "Cidade não fornecida"
        val ufValor = uf.selectedItem.toString()

        val formulario = Formulario(nomeValor, telefoneValor, emailValor, emailListValor, sexoValor, cidadeValor, ufValor)
        Log.d("Teste", formulario.toString())
        Toast.makeText(this, formulario.toString(), Toast.LENGTH_LONG).show()
    }
}
