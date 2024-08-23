package br.edu.scl.ifsp.ads.pdm.havagas

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.edu.scl.ifsp.ads.pdm.havagas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val amb: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(amb.root)

        amb.formacaoSp.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
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
                        amb.run{
                            graduacaoLl.visibility = View.VISIBLE
                            fundamentalLl.visibility = View.GONE
                            anoFormatEt.setText("")
                            mestradoLl.visibility = View.GONE
                            monografiaEt.setText("")
                            orientadorEt.setText("")
                        }

                    }
                    else -> {
                        amb.run{
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

        amb.limparBt.setOnClickListener{
            amb.nomeEt.text.clear()
            amb.emailEt.text.clear()
            amb.celularEt.text.clear()
            amb.anoFormatEt.text.clear()
            amb.anoConcluEt.text.clear()
            amb.instituicaoEt.text.clear()
            amb.monografiaEt.text.clear()
            amb.orientadorEt.text.clear()
            amb.dataEt.text.clear()
            amb.telefoneEt.text.clear()
            amb.interesseEt.text.clear()
            amb.telefoneRg.clearCheck()
            amb.sexoRg.clearCheck()
            amb.telefoneCb.isChecked= false
            amb.receberEmailCb.isChecked= false
        }
        amb.telefoneCb.setOnClickListener{
            //Verifica se o CheckBox está selecionado
            if (amb.telefoneCb.isChecked) {
                amb.telefoneLl.visibility = View.VISIBLE
            } else {
                amb.telefoneLl.visibility = View.GONE
            }
        }

        amb.salvarBt.setOnClickListener{
            Toast.makeText(this@MainActivity, "salvo", Toast.LENGTH_SHORT).show()
        }

    }
}