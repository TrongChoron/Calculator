package hcmute.edu.vn.calculator_02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MainActivity extends AppCompatActivity {

    TextView workingTV;
    TextView resultTV;

    String workings = "";
    Double result = null;
    Boolean flag = true;


    // Hàm khởi tạo khi chạy phần mềm - 26/03/2022 - Nguyễn Thành Trọng
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        initTextView();
    }

    // Hàm gán text vào Text View - 26/03/2022 - Nguyễn Thành Trọng
    public void initTextView() {
        workingTV = (TextView) findViewById(R.id.workingTextView);
        resultTV = (TextView) findViewById(R.id.resultTextView);
    }

    // Hàm để tiếp tục tính toán mà không cần clear - 26/03/2022 - Nguyễn Thành Trọng
    public void continueCalculator() {
        if (result != null) {
            workings = String.valueOf(result.doubleValue());
            flag = false;
        }
    }


    // Khi bấm số thì sẽ thực hiện một phép tính mới mà không cần clear - 26/03/2022 - Nguyễn Thành Trọng
    public void clearWhyNumber() {
        if(flag == true) {
            workingTV.setText("");
            workings = "";
            result = null;
            flag = false;
        }
    }

    // Hàm lấy giá trị button để tính toán - 26/03/2022 - Nguyễn Thành Trọng
    public void setWorkings(String givenValue) {
        if (givenValue == "x") givenValue = "*";

        if (givenValue == "÷") givenValue = "/";
        workings = workings + givenValue;
        workingTV.setText(workings);
    }

    // Hàm xóa những phép tính cũng như kết quả đang hiện trên máy tính - 26/03/2022 - Nguyễn Thành Trọng
    public void clearOnClick(View view) {
        workingTV.setText("");
        workings = "";
        resultTV.setText("");
        result = null;
        flag = false;
    }

    // Hàm khi bấm Equal button sẽ hiện ra kết quả - 26/03/2022 - Nguyễn Thành Trọng
    public void resultOnClick(View view) {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");
        try {
            result = (double) engine.eval(workings);
        } catch (ScriptException e) {
            Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT).show();
        }
        if (result != null) {
            resultTV.setText(String.valueOf(result.doubleValue()));
            flag = true;
        }
    }

    // Button số 7 - 26/03/2022 - Nguyễn Thành Trọng
    public void sevenOnClick(View view) {
        clearWhyNumber();
        setWorkings("7");
    }

    // Button số 8 - 26/03/2022 - Nguyễn Thành Trọng
    public void eightOnClick(View view) {
        clearWhyNumber();
        setWorkings("8");
    }

    // Button số 9 - 26/03/2022 - Nguyễn Thành Trọng
    public void nineOnClick(View view) {
        clearWhyNumber();
        setWorkings("9");
    }

    // Button Division - 26/03/2022 - Nguyễn Thành Trọng
    public void divisionOnClick(View view) {
        continueCalculator();
        setWorkings("÷");
    }

    // Button số 4 - 26/03/2022 - Nguyễn Thành Trọng
    public void fourOnClick(View view) {
        clearWhyNumber();
        setWorkings("4");
    }

    // Button số 5 - 26/03/2022 - Nguyễn Thành Trọng
    public void fiveOnClick(View view) {
        clearWhyNumber();
        setWorkings("5");
    }

    // Button số 6 - 26/03/2022 - Nguyễn Thành Trọng
    public void sixOnClick(View view) {
        clearWhyNumber();
        setWorkings("6");
    }

    // Button Multiple - 26/03/2022 - Nguyễn Thành Trọng
    public void multipleOnClick(View view) {
        continueCalculator();
        setWorkings("x");
    }

    // Button số 1 - 26/03/2022 - Nguyễn Thành Trọng
    public void oneOnClick(View view) {
        clearWhyNumber();
        setWorkings("1");
    }

    // Button số 2 - 26/03/2022 - Nguyễn Thành Trọng
    public void twoOnClick(View view) {
        clearWhyNumber();
        setWorkings("2");
    }

    // Button số 3 - 26/03/2022 - Nguyễn Thành Trọng
    public void threeOnClick(View view) {
        clearWhyNumber();
        setWorkings("3");
    }

    // Button Subtract - 26/03/2022 - Nguyễn Thành Trọng
    public void subtractionOnClick(View view) {
        continueCalculator();
        setWorkings("-");
    }

    // Button số 0 - 26/03/2022 - Nguyễn Thành Trọng
    public void zeroOnClick(View view) {
        clearWhyNumber();
        setWorkings("0");
    }

    // Button Dot - 26/03/2022 - Nguyễn Thành Trọng
    public void dotOnClick(View view) {
        setWorkings(".");
    }

    // Button số Plus - 26/03/2022 - Nguyễn Thành Trọng
    public void addOnClick(View view) {
        continueCalculator();
        setWorkings("+");
    }

}