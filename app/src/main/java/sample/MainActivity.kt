package sample

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.workshop.universityannouncementsboard.util.BaseRecyclerViewAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val api = FactsApi()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        api.getFacts { facts ->
            showFacts(facts)
        }
    }

    private fun showFacts(facts: Facts) {
        uiThread {
            val items = facts.all.map(::FactItemAdapter)
            listView.adapter = BaseRecyclerViewAdapter(items)
            listView.layoutManager = LinearLayoutManager(this)
        }
    }
}