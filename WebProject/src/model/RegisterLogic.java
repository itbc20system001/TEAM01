package model;

import dao.UsrDAO;
import javabeans.Register;

public class RegisterLogic {
	public boolean dbExcute(Register reg) {
		//データベースの成否チェック
		UsrDAO dao = new UsrDAO();
		return dao.create(reg);//
	}

	public boolean inputExcute(Register reg) {

		//ユーザーの入力不備チェック
		if (reg.getL_name() == null || reg.getL_name().length() == 0) {
			//l_nameのチェック ;
			return false;

		} else if (reg.getF_name() == null || reg.getF_name().length() == 0) {
			//f_name ;のチェック
			return false;

		} else if (reg.getL_name_kana() == null || reg.getL_name_kana().length() == 0) {
			//l_name_kanaの入力チェック ;
			return false;

		} else if (reg.getF_name_kana() == null || reg.getF_name_kana().length() == 0) {
			//f_name_kanaの入力チェック ;
			return false;

		} else if (reg.getPrefecture() == null || reg.getPrefecture().length() == 0) {
			//prefectureの入力チェック ;
			return false;

		} else if (reg.getCity() == null || reg.getCity().length() == 0) {
			//cityの入力チェック ;
			return false;

		} else if (reg.getO_address() == null || reg.getO_address().length() == 0) {
			//o_addressの入力チェック ;
			return false;

		} else if (reg.getTel() == null || reg.getTel().length() == 0) {
			//telの入力チェック;
			return false;

		} else if (reg.getEmail() == null || reg.getEmail().length() == 0) {
			//emailの入力チェック ;
			return false;

		} else if (reg.getBirthday() == null || reg.getBirthday().length() == 0) {
			//birthdayの入力チェック;
			return false;

		} else if (reg.getPassword() == null || reg.getPassword().length() == 0) {
			//passwordの入力チェック
			return false;

		} else {
			return true;

		}
	}
}
