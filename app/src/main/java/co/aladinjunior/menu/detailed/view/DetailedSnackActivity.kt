package co.aladinjunior.menu.detailed.view

import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import co.aladinjunior.menu.R
import co.aladinjunior.menu.commom.util.DependecyInjector
import co.aladinjunior.menu.databinding.ActivityDetailedSnackBinding
import co.aladinjunior.menu.detailed.DetailedSnack

class DetailedSnackActivity : AppCompatActivity(), DetailedSnack.View {

    private lateinit var binding: ActivityDetailedSnackBinding
    private lateinit var presenter: DetailedSnack.Presenter
    private var id: Int? = null
    private var previusPrice: Double? = null
    private var previusName: String? = null
    private var icon: Int? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailedSnackBinding.inflate(layoutInflater)
        setContentView(binding.root)


        id =
            intent?.extras?.getInt("id") ?: throw IllegalStateException("nenhum id encontrado!")
        previusPrice =
            intent?.extras?.getDouble("price")
                ?: throw IllegalStateException("nenhum preço encontrado!")
        previusName =
            intent?.extras?.getString("name")
                ?: throw IllegalStateException("nenhum nome encontrado!")
        icon =
            intent?.extras?.getInt("icon") ?: R.drawable.ic_launcher_background




        binding.returnArrow.setOnClickListener {
            finish()
        }

        presenter = DependecyInjector.detailedSnackPresenter(this)
        presenter.loadOnUi(id, previusPrice, previusName, icon)


    }

    override fun setSnackOnUi(id: Int, price: Double, name: String, icon: Int) {
        binding.detailedSnackPrice.setText(
            resources.getString(
                R.string.detailed_price,
                previusPrice
            )
        )
        binding.detailedSnackName.setText(resources.getString(R.string.detailed_name, previusName))
        Toast.makeText(this, "TESTE", Toast.LENGTH_SHORT).show()
        binding.detailedSnackIcon.setImageResource(icon)
    }


}