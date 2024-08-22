package br.edu.scl.ifsp.ads.pdm.havagas

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.helper.widget.Carousel.Adapter
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
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
                if (formacao == "Fundamental" || formacao == "Medio"){
                    amb.fundamentalLl.visibility = View.VISIBLE
                } else{
                    if (formacao == "Graduação" || formacao == "Especialização"){
                        amb.graduacaoLl.visibility = View.VISIBLE
                    } else{
                        if (formacao == "Mestrado" || formacao == "Doutorado"){
                            amb.mestradoLl.visibility = View.VISIBLE
                            amb.graduacaoLl.visibility = View.VISIBLE
                        } else{
                            amb.run{
                                fundamentalLl.visibility = View.GONE
                                anoFormatEt.setText("")
                                graduacaoLl.visibility = View.GONE
                                anoConcluEt.setText("")
                                instituicaoEt.setText("")
                                mestradoLl.visibility = View.GONE
                                monografiaEt.setText("")
                                orientadorEt.setText("")
                            }
                        }
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                //NSA
            }
        }

    }
}