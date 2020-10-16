package sh.surge.jakub.muditarecruitmenttask.countrieslistfragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_recyler_country.view.*
import sh.surge.jakub.muditarecruitmenttask.R
import sh.surge.jakub.muditarecruitmenttask.data.Country
import sh.surge.jakub.muditarecruitmenttask.data.Currency


class CountryAdapter : RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    private val countries: ArrayList<Country> = arrayListOf()

    fun updateList(drummers: List<Country>) {
        this.countries.clear()
        this.countries.addAll(drummers)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder =
        CountryViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_recyler_country, parent, false))

    override fun getItemCount(): Int = countries.size

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.addItem(countries[position])
    }

    class CountryViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun addItem(country: Country) {
            itemView.countryName.text = country.name
            itemView.countryCallingCodes.text = country.callingCodes.toDescription(itemView.context.getString(R.string.callingCodes))
            itemView.countryDomain.text = country.topLevelDomain.toDescription(itemView.context.getString(R.string.countryDomains))
            itemView.countryCurrencies.text = country.currencies.toCurrencyDescription(itemView.context.getString(R.string.currencies))
        }
    }
}

fun List<String>.toDescription(prefix: String): String {
    val sb = StringBuilder()
    for (s in this) {
        sb.append(s)
    }
    return "$prefix $sb"
}
fun List<Currency>.toCurrencyDescription(prefix: String): String {
    val sb = StringBuilder()
    for (s in this)    {
        sb.append("\n")
        sb.append("Name: ${s.name}, ")
        sb.append("Code: ${s.code}, ")
        sb.append("Symbol: ${s.symbol}")
    }
    return "$prefix $sb"
}
