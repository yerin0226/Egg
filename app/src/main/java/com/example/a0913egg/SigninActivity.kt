package com.example.a0913egg

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_signin.*

class SigninActivity : AppCompatActivity() {

    lateinit var inEmail: EditText //이메일
    lateinit var inPw: EditText //비밀번호
    lateinit var signIn: Button //로그인
    lateinit var signUp: TextView //회원가입
    lateinit var findE: TextView //이메일 찾기
    lateinit var findP: TextView //비밀번호 찾기

    var auth : FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        auth = FirebaseAuth.getInstance()

        inEmail = findViewById(R.id.inemail)
        inPw = findViewById(R.id.inpw)
        signIn = findViewById(R.id.signin)
        signUp = findViewById(R.id.signup)
        findE = findViewById(R.id.findemail)
        findP = findViewById(R.id.findpw)

        signIn.setOnClickListener{
            signinEmail()
        }
        signUp.setOnClickListener{
            //회원가입
            //회원가입 화면으로 전환
            startActivity(Intent(this,SignupActivity::class.java))
        }
        findE.setOnClickListener{
            //이메일 찾기
        }
        findP.setOnClickListener{
            //비밀번호 찾기
        }

    }

    fun signinEmail() {
        auth?.signInWithEmailAndPassword(inemail.text.toString(),inpw.text.toString())
            ?.addOnCompleteListener {
                    task ->
                if(task.isSuccessful) {
                    // Login, 아이디와 패스워드가 맞았을 때
                    moveMainPage(task.result?.user)
                } else {
                    // Show the error message, 아이디와 패스워드가 틀렸을 때
                    Toast.makeText(this, task.exception?.message, Toast.LENGTH_LONG).show()
                }
            }
    }

    // 로그인이 성공하면 다음 페이지로 넘어가는 함수
    fun moveMainPage(user: FirebaseUser?) {
        // 파이어베이스 유저 상태가 있을 경우 다음 페이지로 넘어갈 수 있음
        if(user != null) {
            startActivity(Intent(this, NaviActivity::class.java))
        }
    }
}