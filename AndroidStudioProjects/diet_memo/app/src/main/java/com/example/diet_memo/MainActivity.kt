package com.example.diet_memo

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.util.*

class MainActivity : AppCompatActivity() {
    val dataModelList = mutableListOf<DataModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val database = Firebase.database
        val myRef = database.getReference("myMemo")
        val listView = findViewById<ListView>(R.id.mainLV)
        val adapter_list = ListViewAdapter(dataModelList)

        listView.adapter = adapter_list

        myRef.child(Firebase.auth.currentUser!!.uid).addValueEventListener(object : ValueEventListener{ // 내꺼만 불러와주세요...
            override fun onDataChange(snapshot: DataSnapshot) {
               dataModelList.clear()

               for(dataModel in snapshot.children){
                   Log.d("Data", dataModel.toString())
                   dataModelList.add(dataModel.getValue(DataModel::class.java)!!)
                   }
                Log.d("DataModel", dataModelList.toString())
                adapter_list.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

        val writeButton = findViewById<ImageView>(R.id.writeBtn)

        writeButton.setOnClickListener {
            val mDialogView = LayoutInflater.from(this).inflate(R.layout.custom_dialog, null)
            val mBuilder = AlertDialog.Builder(this).setView(mDialogView).setTitle("운동메모다이얼로그")
            val mAlertDialog = mBuilder.show()

            val DataSelectBtn = mAlertDialog.findViewById<Button>(R.id.dateSelectBtn)
            var dateText = ""

            DataSelectBtn?.setOnClickListener {

                val today = GregorianCalendar()
                val year: Int = today.get(Calendar.YEAR)
                val month: Int = today.get(Calendar.MONTH)
                val date: Int = today.get(Calendar.DATE)

                val dlg = DatePickerDialog(this, object : DatePickerDialog.OnDateSetListener {
                    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int
                    ) {
                        Log.d("MAIN","${year},${month+1},${dayOfMonth}")
                        DataSelectBtn.setText("${year},${month+1},${dayOfMonth}")
                        dateText = "${year},${month+1},${dayOfMonth}"
                    }
                }, year, month, date)
                dlg.show()
            }

            val saveBtn = mAlertDialog.findViewById<Button>(R.id.saveBtn)
            saveBtn?.setOnClickListener {

                val healMemo = mAlertDialog.findViewById<EditText>(R.id.healthMemo)?.text.toString()

                val database = Firebase.database
                val myRef = database.getReference("myMemo").child(Firebase.auth.currentUser!!.uid) // 나만볼수있게 해주세요 내꺼니깐..

                val model = DataModel(dateText,healMemo)

                myRef
                    .push()
                    .setValue(model)

                mAlertDialog.dismiss() // 다이얼로그 종료
            }
        }
    }
}