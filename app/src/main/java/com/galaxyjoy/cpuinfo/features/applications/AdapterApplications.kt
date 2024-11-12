package com.galaxyjoy.cpuinfo.features.applications

import android.annotation.SuppressLint
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.galaxyjoy.cpuinfo.R
import com.galaxyjoy.cpuinfo.utils.Utils
import com.galaxyjoy.cpuinfo.utils.glide.GlideApp
import com.galaxyjoy.cpuinfo.utils.runOnApiBelow
import com.galaxyjoy.cpuinfo.widgets.swiperv.SwipeHorizontalMenuLayout


/**
 * Adapter for application list with sliding items
 *
 * @author galaxyjoy
 */
class AdapterApplications(
    private val appList: List<ExtendedAppInfo>,
    private val appClickListener: ItemClickListener
) : RecyclerView.Adapter<AdapterApplications.ApplicationViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ApplicationViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.v_item_swipe_app, parent, false)
        return ApplicationViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ApplicationViewHolder,
        position: Int
    ) {
        val app = appList[position]
        holder.bind(app, appClickListener)
    }

    override fun getItemCount(): Int = appList.size

    class ApplicationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val storageLabel: String = itemView.context.getString(R.string.storage_used)
        private val calculatingLabel: String = itemView.context.getString(R.string.calculating)

        private val iconIv: ImageView = itemView.findViewById(R.id.appIcon)
        private val nameTv: TextView = itemView.findViewById(R.id.appName)
        private val packageTv: TextView = itemView.findViewById(R.id.appPackage)
        private val storageTv: TextView = itemView.findViewById(R.id.storageUsage)
        private val sml: SwipeHorizontalMenuLayout = itemView.findViewById(R.id.sml)
        private val mainContainer: View = itemView.findViewById(R.id.smContentView)
        private val settingsV: View = itemView.findViewById(R.id.settings)
        private val deleteView: View = itemView.findViewById(R.id.delete)
        private val nativeButtonIV: ImageView = itemView.findViewById(R.id.nativeButton)

        @SuppressLint("SetTextI18n")
        fun bind(app: ExtendedAppInfo, appClickListener: ItemClickListener) {
            GlideApp.with(iconIv.context)
                .load(app.appIconUri)
                .transition(DrawableTransitionOptions.withCrossFade())
                .fitCenter()
                .into(iconIv)

            nameTv.text = app.name
            packageTv.text = app.packageName

            runOnApiBelow(Build.VERSION_CODES.O, {
                val size =
                    if (app.appSize == 0L) calculatingLabel
                    else Utils.humanReadableByteCount(app.appSize)
                storageTv.text = "$storageLabel $size"
            }, {
                storageTv.visibility = View.GONE
            })

            mainContainer.setOnClickListener {
                val pos = bindingAdapterPosition
                if (pos != RecyclerView.NO_POSITION) {
                    appClickListener.appOpenClicked(pos)
                }
            }
            settingsV.setOnClickListener {
                val pos = bindingAdapterPosition
                if (pos != RecyclerView.NO_POSITION) {
                    appClickListener.appSettingsClicked(bindingAdapterPosition)
                }
            }
            deleteView.setOnClickListener {
                val pos = bindingAdapterPosition
                if (pos != RecyclerView.NO_POSITION) {
                    sml.smoothCloseMenu()
                    appClickListener.appUninstallClicked(bindingAdapterPosition)
                }
            }
            nativeButtonIV.setOnClickListener {
                app.nativeLibraryDir?.let { appClickListener.appNativeLibsClicked(it) }
            }
            if (app.hasNativeLibs) {
                nativeButtonIV.visibility = View.VISIBLE
            } else {
                nativeButtonIV.visibility = View.GONE
            }
        }
    }

    /**
     * Interface for communication with activity
     */
    interface ItemClickListener {
        fun appOpenClicked(position: Int)
        fun appSettingsClicked(position: Int)
        fun appUninstallClicked(position: Int)
        fun appNativeLibsClicked(nativeDir: String)
    }
}
