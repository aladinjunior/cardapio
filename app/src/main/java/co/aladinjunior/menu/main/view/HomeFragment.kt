package co.aladinjunior.menu.main.view

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import co.aladinjunior.menu.R
import co.aladinjunior.menu.commom.util.DependecyInjector
import co.aladinjunior.menu.databinding.FragmentHomeBinding
import co.aladinjunior.menu.main.Home
import co.aladinjunior.menu.main.presentation.HomePresenter
import co.aladinjunior.menu.model.Snack


class HomeFragment(private var adapter: Adapter? = null) : Fragment(R.layout.fragment_home), Home.View {

    private lateinit var presenter: HomePresenter
    private var binding: FragmentHomeBinding? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        presenter = HomePresenter(this, DependecyInjector.homeRepository())
        adapter = Adapter(context = context)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)

        presenter.getSnacks()

        binding?.let {
            with(it){
                rvMain.layoutManager = LinearLayoutManager(activity)
                rvMain.adapter = adapter
            }
        }

    }

    override fun onDestroy() {
        binding = null
        adapter = null
        super.onDestroy()
    }

    override fun displayProgress(enabled: Boolean) {
        if (enabled == true) binding?.progressBar?.visibility = View.VISIBLE
        else binding?.progressBar?.visibility = View.GONE
    }

    override fun showOnUi(listOfSnacks: List<Snack>) {
        adapter?.updateSnacks(listOfSnacks)
        adapter?.notifyDataSetChanged()
    }

}


