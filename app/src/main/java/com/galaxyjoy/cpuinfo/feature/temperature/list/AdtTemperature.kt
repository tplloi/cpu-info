package com.galaxyjoy.cpuinfo.feature.temperature.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.galaxyjoy.cpuinfo.databinding.ViItemTemperatureBinding
import com.galaxyjoy.cpuinfo.feature.temperature.TemperatureFormatter

/**
 * Temperature list adapter which observe temperatureListLiveData
 *
 */
class AdtTemperature(
    private val temperatureFormatter: TemperatureFormatter,
    private val temperatureList: List<TemperatureItem>
) : RecyclerView.Adapter<AdtTemperature.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ViItemTemperatureBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding, temperatureFormatter)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        holder.bind(temperatureList[position])
    }

    override fun getItemCount(): Int = temperatureList.size

    class ViewHolder(
        private val binding: ViItemTemperatureBinding,
        private val temperatureFormatter: TemperatureFormatter
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(temperatureItem: TemperatureItem) {
            with(binding) {
                temperatureIv.setImageResource(temperatureItem.iconRes)
                temperatureTypeTv.text = temperatureItem.name
                temperatureTv.text = temperatureFormatter.format(temperatureItem.temperature)
            }
        }
    }
}
