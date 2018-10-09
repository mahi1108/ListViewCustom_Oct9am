package cubex.mahesh.listviewcustom_oct9am

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.indiview.view.*
import java.io.File

class MyAdapter(var activity: MainActivity,
                var files:Array<File>):BaseAdapter()
{
    override fun getView(pos: Int, p1: View?, p2: ViewGroup?): View {
        var inflater = LayoutInflater.from(activity)
        var view = inflater.inflate(R.layout.indiview,null)
        var file = files[pos]
        view.iview.setImageURI(Uri.fromFile(file))
        view.name.text = file.name
        view.size.text = file.length().toString()
        view.del.setOnClickListener {
            file.delete()
            activity.readFiles()
        }

        return view
    }
    override fun getItem(p0: Int): Any {
        return  0
    }
    override fun getItemId(p0: Int): Long {
        return 0
    }
    override fun getCount(): Int {
            return  files.size
      }

}