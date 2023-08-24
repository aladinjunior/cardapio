package co.aladinjunior.menu.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.aladinjunior.menu.R
import co.aladinjunior.menu.model.Snack
import co.aladinjunior.menu.presentation.HomePresenter

class HomeFragment : Fragment() {

    private lateinit var presenter: HomePresenter
    private lateinit var adapter: Adapter
    private lateinit var progress: ProgressBar

    override fun onAttach(context: Context) {
        super.onAttach(context)
        presenter = HomePresenter(this)
        adapter = Adapter(context = context)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.getSnacks()
        val rv = view.findViewById<RecyclerView>(R.id.rv_main)
        progress = view.findViewById(R.id.progress_bar)
        rv.layoutManager = LinearLayoutManager(activity)
        rv.adapter = adapter

    }

    fun getDataFromPresenter(listOfSnacks: List<Snack>){
        adapter.updateSnacks(listOfSnacks)
        adapter.notifyDataSetChanged()
    }

    fun hideProgress(){
        progress.visibility = View.GONE
    }


}


