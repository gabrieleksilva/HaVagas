package br.edu.scl.ifsp.ads.pdm.havagas

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.edu.scl.ifsp.ads.pdm.havagas.databinding.ActivityMainBinding
//falta mostra o campo de celular
class MainActivity : AppCompatActivity() {
    private val amb: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private var receberEmail: String? = " "
    private var inserirCel: String? = " "
    private var tipoTel: String? = " "
    private var sexo: String? = " "
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(amb.root)

        amb.run {
            formacaoSp.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    val formacao = (view as TextView).text.toString()

                    when (formacao) {
                        "Fundamental", "Medio" -> {
                            amb.run {
                                amb.fundamentalLl.visibility = View.VISIBLE
                                amb.graduacaoLl.visibility = View.GONE
                                amb.anoConcluEt.setText("")
                                amb.instituicaoEt.setText("")
                                amb.mestradoLl.visibility = View.GONE
                                amb.monografiaEt.setText("")
                                amb.orientadorEt.setText("")
                            }
                        }

                        "Graduação", "Especialização" -> {
                            amb.run {
                                graduacaoLl.visibility = View.VISIBLE
                                fundamentalLl.visibility = View.GONE
                                anoFormatEt.setText("")
                                mestradoLl.visibility = View.GONE
                                monografiaEt.setText("")
                                orientadorEt.setText("")
                            }

                        }

                        else -> {
                            amb.run {
                                fundamentalLl.visibility = View.GONE
                                anoFormatEt.setText("")
                                mestradoLl.visibility = View.VISIBLE
                                graduacaoLl.visibility = View.VISIBLE
                            }
                        }
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    //NSA
                }
            }

            limparBt.setOnClickListener {
                amb.run {
                    nomeEt.text.clear()
                    emailEt.text.clear()
                    celularEt.text.clear()
                    anoFormatEt.text.clear()
                    anoConcluEt.text.clear()
                    instituicaoEt.text.clear()
                    monografiaEt.text.clear()
                    orientadorEt.text.clear()
                    dataEt.text.clear()
                    telefoneEt.text.clear()
                    interesseEt.text.clear()
                    telefoneRg.clearCheck()
                    sexoRg.clearCheck()
                    telefoneCb.isChecked = false
                    receberEmailCb.isChecked = false
                }
            }

            receberEmailCb.setOnClickListener {
                if (amb.receberEmailCb.isChecked) {
                    receberEmail = amb.receberEmailCb.text.toString()
                } else {
                    receberEmail = ""
                }
            }

            telefoneCb.setOnClickListener {
                if (amb.telefoneCb.isChecked) {
                    inserirCel = amb.telefoneCb.text.toString()
                    amb.telefoneLl.visibility = View.VISIBLE
                } else {
                    amb.telefoneLl.visibility = View.GONE
                    inserirCel = ""
                }
            }

            telefoneRg.setOnCheckedChangeListener { group, checkedId ->
                tipoTel = when (checkedId) {
                    R.id.residencialRb -> amb.residencialRb.text.toString()
                    R.id.comercialRb -> amb.comercialRb.text.toString()
                    else -> ""  // Nenhum botão selecionado
                }
            }

            sexoRg.setOnCheckedChangeListener { group, checkedId ->
                sexo = when (checkedId) {
                    R.id.masculinoRb -> amb.masculinoRb.text.toString()
                    R.id.femininoRb -> amb.femininoRb.text.toString()
                    else -> ""  // Nenhum botão selecionado
                }
            }

            salvarBt.setOnClickListener {
                val editTexts = listOf(
                    amb.run {
                        nomeEt.text.toString() + " " +
                                emailEt.text.toString() + " " +
                                receberEmail + " " +
                                telefoneEt.text + " " +
                                //comercial ou residencial
                                tipoTel + " " +
                                inserirCel + " " +
                                celularEt.text + " " +
                                sexo + " " +
                                anoFormatEt.text + " " +
                                anoConcluEt.text + " " +
                                instituicaoEt.text + " " +
                                monografiaEt.text + " " +
                                orientadorEt.text + " " +
                                dataEt.text + " " +
                                interesseEt.text + " "
                    }
                )

                editTexts.forEach { editText ->
                    Toast.makeText(this@MainActivity, editText.trim(), Toast.LENGTH_LONG)
                        .show()
                }
            }
        }
    }
}