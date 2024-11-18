package com.galaxyjoy.cpuinfo.feature.processes

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.galaxyjoy.cpuinfo.R
import com.galaxyjoy.cpuinfo.util.Utils

/**
 * Simple adapter for processes
 **/
class AdtProcesses(private val processList: List<ProcessItem>) :
    RecyclerView.Adapter<AdtProcesses.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.vi_item_process, parent, false)
        return ViewHolder(v)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val process = processList[position]
        holder.nameTv.text = process.name
        holder.pidTv.text = "PID: ${process.pid}"
        holder.ppidTv.text = "PPID: ${process.ppid}"
        holder.nicenessTv.text = "NICENESS: ${process.niceness}"
        holder.userTv.text = "USER: ${process.user}"
        holder.rssTv.text = "RSS: ${Utils.humanReadableByteCount(process.rss.toLong() * 1024)}"
        holder.vsizeTv.text = "VSZ: ${Utils.humanReadableByteCount(process.vsize.toLong() * 1024)}"
    }

    override fun getItemCount(): Int =
        processList.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTv: TextView = itemView.findViewById(R.id.procNameTv)
        val pidTv: TextView = itemView.findViewById(R.id.procPidTv)
        val ppidTv: TextView = itemView.findViewById(R.id.procPpidTv)
        val nicenessTv: TextView = itemView.findViewById(R.id.procNicTv)
        val userTv: TextView = itemView.findViewById(R.id.procUserTv)
        val rssTv: TextView = itemView.findViewById(R.id.procRssTv)
        val vsizeTv: TextView = itemView.findViewById(R.id.procVsizeTv)
    }
}
