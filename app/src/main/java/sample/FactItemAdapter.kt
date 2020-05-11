package sample

import kotlinx.android.synthetic.main.item_fact.*

data class FactItemAdapter(private val fact: Fact) : ItemAdapter(R.layout.item_fact) {

    override fun setupView() {
        textView.text = fact.text
    }
}