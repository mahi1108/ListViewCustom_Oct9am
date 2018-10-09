package cubex.mahesh.listviewcustom_oct9am

import android.Manifest
import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var status = ContextCompat.checkSelfPermission(
                this@MainActivity,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
        if(status==PackageManager.PERMISSION_GRANTED){
            readFiles()
        }else{
            ActivityCompat.requestPermissions(this@MainActivity,
                    arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                    124)
        }
    }

    fun readFiles( )
    {
        var path="/storage/sdcard0/WhatsApp/Media/WhatsApp Images/"
        var f = File(path)
        if(!f.exists()){
            path="/storage/emulated/0/WhatsApp/Media/WhatsApp Images/"
           f = File(path)
        }
       var files:Array<File> =  f.listFiles()
        lview.adapter = MyAdapter(this@MainActivity,files)
    }

    override fun onRequestPermissionsResult(requestCode: Int,
                      permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if(grantResults[0]==PackageManager.PERMISSION_GRANTED){
            readFiles()
        }else{

        }

    }


}
