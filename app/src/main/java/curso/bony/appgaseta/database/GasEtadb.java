package curso.bony.appgaseta.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class GasEtadb extends SQLiteOpenHelper {

    public static final String DB_NAME="GasEta.db";

    Cursor cursor;
    SQLiteDatabase db;
    public static final int DB_VERSION=1;
    public GasEtadb(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        db=getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //QUERY SQL para criar uma tabela
        String sqlTabelaCombustivel= "CREATE TABLE combustivel(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nomeDoCOmbustivel TEXT, " +
                "precoDoCombustivel REAL, " +
                "recomendacao TEXT)";
        db.execSQL(sqlTabelaCombustivel);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //Criar metodo para implimentar um CRUD;
    //C = criete cria o banco de dados e as tabelas
    //c

    //R = Retrieve
}
