package testReg;

public class TestUnicode {

	public static void main(String[] args) {
		System.out.println(convertString("// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.\r\n" + 
				"// Jad home page: http://www.kpdus.com/jad.html\r\n" + 
				"// Decompiler options: packimports(3) \r\n" + 
				"// Source File Name:   KFTCPayRefundBatch.java\r\n" + 
				"\r\n" + 
				"package com.jeju.payment.kftc.batch;\r\n" + 
				"\r\n" + 
				"import com.jeju.payment.kftc.batch.databean.KFTCPayDataBean;\r\n" + 
				"import com.jeju.payment.kftc.batch.databean.KFTCRefundFailureDataBean;\r\n" + 
				"import com.jeju.payment.kftc.batch.databean.PaymentDataBean;\r\n" + 
				"import com.jeju.payment.kftc.db.DBConnection;\r\n" + 
				"import com.jeju.payment.kftc.util.DateUtil;\r\n" + 
				"import com.jeju.payment.kftc.util.StringUtil;\r\n" + 
				"import java.sql.*;\r\n" + 
				"import java.util.*;\r\n" + 
				"import org.apache.commons.logging.Log;\r\n" + 
				"import org.apache.commons.logging.LogFactory;\r\n" + 
				"\r\n" + 
				"// Referenced classes of package com.jeju.payment.kftc.batch:\r\n" + 
				"//            KFTCPayNew, KFTCPaymentCommon\r\n" + 
				"\r\n" + 
				"public class KFTCPayRefundBatch extends KFTCPayNew\r\n" + 
				"{\r\n" + 
				"\r\n" + 
				"    public KFTCPayRefundBatch()\r\n" + 
				"    {\r\n" + 
				"        hd_approve_no = \"\";\r\n" + 
				"        hd_password = \"\";\r\n" + 
				"        payCommon = new KFTCPaymentCommon();\r\n" + 
				"        strUtil = new StringUtil();\r\n" + 
				"        dateUtil = new DateUtil();\r\n" + 
				"        Common_Logger = null;\r\n" + 
				"        con = null;\r\n" + 
				"        FROM_DATE = \"\";\r\n" + 
				"        Common_Logger = LogFactory.getLog(\"KFTCRefund\");\r\n" + 
				"    }\r\n" + 
				"\r\n" + 
				"    public static void main(String args[])\r\n" + 
				"    {\r\n" + 
				"        String _FromDate;\r\n" + 
				"        DateUtil _dateUtil;\r\n" + 
				"        KFTCPayRefundBatch _refund;\r\n" + 
				"        _FromDate = \"\";\r\n" + 
				"        _dateUtil = new DateUtil();\r\n" + 
				"        _refund = new KFTCPayRefundBatch();\r\n" + 
				"        if(args == null)\r\n" + 
				"        {\r\n" + 
				"            _refund.Common_Logger.debug(\"=========== \\uD30C\\uB77C\\uBBF8\\uD130\\uAC00 \\uC5C6\\uB294 \\uACBD\\uC6B0 Default \\uC73C\\uB85C \\uC138\\uD305 ========\");\r\n" + 
				"            _refund.Common_Logger.debug(\" 0 : Search Date [ UNIT : yyyyMMdd ] : Current Date\");\r\n" + 
				"            _FromDate = _dateUtil.getCurrentDate(\"yyyyMMdd\");\r\n" + 
				"        } else\r\n" + 
				"        if(args != null)\r\n" + 
				"            if(args.length != 1)\r\n" + 
				"            {\r\n" + 
				"                _refund.Common_Logger.debug(\"=========== \\uD30C\\uB77C\\uBBF8\\uD130\\uAC00 \\uC5C6\\uB294 \\uACBD\\uC6B0 Default \\uC73C\\uB85C \\uC138\\uD305 ========\");\r\n" + 
				"                _refund.Common_Logger.debug(\" 0 : Search Date [ UNIT : yyyyMMdd ] : Current Date\");\r\n" + 
				"                _FromDate = _dateUtil.getCurrentDate(\"yyyyMMdd\");\r\n" + 
				"            } else\r\n" + 
				"            if(args[0] == null)\r\n" + 
				"            {\r\n" + 
				"                _refund.Common_Logger.debug(\"=========== \\uD30C\\uB77C\\uBBF8\\uD130\\uAC00 \\uC5C6\\uB294 \\uACBD\\uC6B0 Default \\uC73C\\uB85C \\uC138\\uD305 ========\");\r\n" + 
				"                _refund.Common_Logger.debug(\" 0 : Search Date [ UNIT : yyyyMMdd ] : Current Date\");\r\n" + 
				"                _FromDate = _dateUtil.getCurrentDate(\"yyyyMMdd\");\r\n" + 
				"            } else\r\n" + 
				"            {\r\n" + 
				"                _refund.Common_Logger.debug(\"=========== \\uD30C\\uB77C\\uBBF8\\uD130\\uAC00 \\uC788\\uB294 \\uACBD\\uC6B0 Input Value\\uC73C\\uB85C \\uC138\\uD305 ========\");\r\n" + 
				"                _refund.Common_Logger.debug(\" 0 : Search Date\");\r\n" + 
				"                _FromDate = args[0];\r\n" + 
				"            }\r\n" + 
				"        try\r\n" + 
				"        {\r\n" + 
				"            if(!_dateUtil.isDate(_FromDate, \"yyyyMMdd\"))\r\n" + 
				"                throw new Exception(\"Date Type\\uC774 \\uC798\\uBABB \\uB418\\uC5C8\\uC2B5\\uB2C8\\uB2E4.\");\r\n" + 
				"            _FromDate = (new StringBuilder(String.valueOf(_FromDate))).append(\"000000\").toString();\r\n" + 
				"            _refund.FROM_DATE = _FromDate;\r\n" + 
				"            _refund.FROM_DATE = _dateUtil.getTimeRegulate(_refund.FROM_DATE, \"DATE\", -180);\r\n" + 
				"            _refund.FROM_DATE = _dateUtil.changeDateFormat(_refund.FROM_DATE, \"yyyyMMddHHmmss\", \"yyyyMMdd\", Locale.KOREA, Locale.KOREA);\r\n" + 
				"            _refund.con = DBConnection.getPaymentDBConnection();\r\n" + 
				"            _refund.doTask();\r\n" + 
				"            break MISSING_BLOCK_LABEL_301;\r\n" + 
				"        }\r\n" + 
				"        catch(Exception ex)\r\n" + 
				"        {\r\n" + 
				"            _refund.Common_Logger.info(ex);\r\n" + 
				"            ex.printStackTrace();\r\n" + 
				"        }\r\n" + 
				"        DBConnection.closeConnection(_refund.con);\r\n" + 
				"        break MISSING_BLOCK_LABEL_309;\r\n" + 
				"        Exception exception;\r\n" + 
				"        exception;\r\n" + 
				"        DBConnection.closeConnection(_refund.con);\r\n" + 
				"        throw exception;\r\n" + 
				"        DBConnection.closeConnection(_refund.con);\r\n" + 
				"    }\r\n" + 
				"\r\n" + 
				"    private LinkedList searchRequestRFInformation()\r\n" + 
				"        throws Exception\r\n" + 
				"    {\r\n" + 
				"        ResultSet _rs;\r\n" + 
				"        PreparedStatement _ps;\r\n" + 
				"        StringBuffer _sqlBuf;\r\n" + 
				"        LinkedList _RequestRFInformation;\r\n" + 
				"        _rs = null;\r\n" + 
				"        _ps = null;\r\n" + 
				"        _sqlBuf = new StringBuffer();\r\n" + 
				"        _RequestRFInformation = new LinkedList();\r\n" + 
				"        PaymentDataBean _payData = null;\r\n" + 
				"        KFTCRefundFailureDataBean _RefundFailureData = null;\r\n" + 
				"        String _prcDate = \"\";\r\n" + 
				"        try\r\n" + 
				"        {\r\n" + 
				"            _sqlBuf.append(\" SELECT *  FROM  TBNORKFTCRFFL \\n\");\r\n" + 
				"            _sqlBuf.append(\"          WHERE  FDSEQNO IS NOT NULL \\n\");\r\n" + 
				"            _sqlBuf.append(\"            AND FDRESPONSECODE IN ('822', '936') \\n\");\r\n" + 
				"            _sqlBuf.append(\"            AND  FDRFPROCESS = 'F' \\n\");\r\n" + 
				"            _sqlBuf.append((new StringBuilder(\"            AND  FDORIGINPAYMENTDT > '\")).append(FROM_DATE).append(\"' \\n\").toString());\r\n" + 
				"            Common_Logger.info(_sqlBuf.toString());\r\n" + 
				"            _ps = con.prepareStatement(_sqlBuf.toString());\r\n" + 
				"            KFTCRefundFailureDataBean _RefundFailureData;\r\n" + 
				"            for(_rs = _ps.executeQuery(); _rs.next(); _RequestRFInformation.add(_RefundFailureData))\r\n" + 
				"            {\r\n" + 
				"                _RefundFailureData = new KFTCRefundFailureDataBean();\r\n" + 
				"                _RefundFailureData.setSeqNo(strUtil.n2b(_rs.getString(\"FDSEQNO           \".trim())));\r\n" + 
				"                _RefundFailureData.setAgentID(strUtil.n2b(_rs.getString(\"FDAGENTCODE       \".trim())));\r\n" + 
				"                _RefundFailureData.setOriginPaymentDate(strUtil.n2b(_rs.getString(\"FDORIGINPAYMENTDT \".trim())));\r\n" + 
				"                _RefundFailureData.setOriginTelegramSeqNo(strUtil.n2b(_rs.getString(\"FDORITELEGRAMSEQNO\".trim())));\r\n" + 
				"                _RefundFailureData.setResponseCode(strUtil.n2b(_rs.getString(\"FDRESPONSECODE    \".trim())));\r\n" + 
				"                _RefundFailureData.setRefundAmount(strUtil.n2b(_rs.getString(\"FDRFAMOUNT        \".trim())));\r\n" + 
				"                _RefundFailureData.setPnrAlpha(strUtil.n2b(_rs.getString(\"FDPNRALPHA        \".trim())));\r\n" + 
				"                _RefundFailureData.setPnrNumeric(strUtil.n2b(_rs.getString(\"FDPNRNUMERIC      \".trim())));\r\n" + 
				"                _RefundFailureData.setInsertDateTime(strUtil.n2b(_rs.getString(\"FDINSERTDATETIME  \".trim())));\r\n" + 
				"                _RefundFailureData.setRefundProcess(strUtil.n2b(_rs.getString(\"FDRFPROCESS       \".trim())));\r\n" + 
				"                _RefundFailureData.setModifyUser(strUtil.n2b(_rs.getString(\"FDMODUSER         \".trim())));\r\n" + 
				"                _RefundFailureData.setModifyDate(strUtil.n2b(_rs.getString(\"FDMODDATE         \".trim())));\r\n" + 
				"                _RefundFailureData.setUserDefineData(strUtil.n2b(_rs.getString(\"FDUSERDFDATA      \".trim())));\r\n" + 
				"                _RefundFailureData.setRefundDegree(strUtil.parseInt(_rs.getString(\"FDRFDEGREE   \".trim())));\r\n" + 
				"            }\r\n" + 
				"\r\n" + 
				"        }\r\n" + 
				"        catch(Exception ex)\r\n" + 
				"        {\r\n" + 
				"            throw ex;\r\n" + 
				"        }\r\n" + 
				"        break MISSING_BLOCK_LABEL_513;\r\n" + 
				"        Exception exception;\r\n" + 
				"        exception;\r\n" + 
				"        try\r\n" + 
				"        {\r\n" + 
				"            _rs.close();\r\n" + 
				"        }\r\n" + 
				"        catch(Exception exception1) { }\r\n" + 
				"        try\r\n" + 
				"        {\r\n" + 
				"            _ps.close();\r\n" + 
				"        }\r\n" + 
				"        catch(Exception exception2) { }\r\n" + 
				"        throw exception;\r\n" + 
				"        try\r\n" + 
				"        {\r\n" + 
				"            _rs.close();\r\n" + 
				"        }\r\n" + 
				"        catch(Exception exception3) { }\r\n" + 
				"        try\r\n" + 
				"        {\r\n" + 
				"            _ps.close();\r\n" + 
				"        }\r\n" + 
				"        catch(Exception exception4) { }\r\n" + 
				"        return _RequestRFInformation;\r\n" + 
				"    }\r\n" + 
				"\r\n" + 
				"    private void doTask()\r\n" + 
				"        throws Exception\r\n" + 
				"    {\r\n" + 
				"        LinkedList _RequestRFInformation = new LinkedList();\r\n" + 
				"        DateUtil dateUtil = new DateUtil();\r\n" + 
				"        String bankSalesDate = \"\";\r\n" + 
				"        try\r\n" + 
				"        {\r\n" + 
				"            bankSalesDate = payCommon.getBankSalesDate(dateUtil.getCurrentDate(\"yyyyMMdd\"));\r\n" + 
				"            Common_Logger.info((new StringBuilder(\"\\uC740\\uD589\\uC601\\uC5C5\\uC77C \\uD655\\uC778 : \")).append(bankSalesDate).toString());\r\n" + 
				"            if(bankSalesDate.equals(\"\\uC601\\uC5C5\\uC77C\"))\r\n" + 
				"            {\r\n" + 
				"                _RequestRFInformation = searchRequestRFInformation();\r\n" + 
				"                Common_Logger.info((new StringBuilder(\"1. \\uCDE8\\uC18C\\uC694\\uCCAD\\uB370\\uC774\\uD130 \\uC0AC\\uC774\\uC988:\")).append(_RequestRFInformation.size()).toString());\r\n" + 
				"                for(int _ReqRFInfoIdx = 0; _ReqRFInfoIdx < _RequestRFInformation.size(); _ReqRFInfoIdx++)\r\n" + 
				"                {\r\n" + 
				"                    KFTCRefundFailureDataBean _RefundFailureData = (KFTCRefundFailureDataBean)_RequestRFInformation.get(_ReqRFInfoIdx);\r\n" + 
				"                    String _SeqNo = _RefundFailureData.getSeqNo();\r\n" + 
				"                    String _OriginPaymentDate = _RefundFailureData.getOriginPaymentDate();\r\n" + 
				"                    String _OriginTelegramSeqNo = _RefundFailureData.getOriginTelegramSeqNo();\r\n" + 
				"                    String _RefundAmount = _RefundFailureData.getRefundAmount();\r\n" + 
				"                    String _userDefine = _RefundFailureData.getUserDefineData();\r\n" + 
				"                    PaymentDataBean loPaymentDataBeanReq = new PaymentDataBean();\r\n" + 
				"                    loPaymentDataBeanReq.setTelegramSeqNo(_OriginTelegramSeqNo);\r\n" + 
				"                    loPaymentDataBeanReq.setTransactionDate(_OriginPaymentDate);\r\n" + 
				"                    PaymentDataBean _alreadyPayData = payCommon.searchCashAlreadyPaymentHistory(loPaymentDataBeanReq, _RefundAmount);\r\n" + 
				"                    Common_Logger.info((new StringBuilder(\"\\uC5D0\\uC774\\uC804\\uD2B8ID:\")).append(_alreadyPayData.getAgentID()).toString());\r\n" + 
				"                    Common_Logger.info((new StringBuilder(\"TelegramSeqNo/PaymentDate/_RefundAmount\")).append(_OriginTelegramSeqNo).append(\"/\").append(_OriginPaymentDate).append(\"/\").append(_RefundAmount).toString());\r\n" + 
				"                    if(_alreadyPayData != null)\r\n" + 
				"                    {\r\n" + 
				"                        Common_Logger.info((new StringBuilder(\"\\uB370\\uC774\\uD130\")).append(_alreadyPayData.toString()).toString());\r\n" + 
				"                        KFTCPayDataBean _kftcPayDt = cancelPayment(_OriginPaymentDate, _RefundAmount, _OriginTelegramSeqNo, _userDefine, _alreadyPayData);\r\n" + 
				"                        if(_kftcPayDt == null)\r\n" + 
				"                            Common_Logger.info(\"_kftcPatDt is null\");\r\n" + 
				"                        else\r\n" + 
				"                            payCommon.updateRefundProcessInTBNORKFTCRFFL(_SeqNo, _kftcPayDt.getResp_code(), \"T\");\r\n" + 
				"                    } else\r\n" + 
				"                    {\r\n" + 
				"                        Common_Logger.info(\"\\uAE30\\uC874\\uC5D0 \\uC694\\uCCAD\\uD588\\uB358 \\uC815\\uBCF4\\uAC00 \\uC874\\uC7AC\\uD558\\uC9C0 \\uC54A\\uC2B5\\uB2C8\\uB2E4.\");\r\n" + 
				"                    }\r\n" + 
				"                }\r\n" + 
				"\r\n" + 
				"                return;\r\n" + 
				"            }\r\n" + 
				"        }\r\n" + 
				"        catch(Exception ex)\r\n" + 
				"        {\r\n" + 
				"            throw ex;\r\n" + 
				"        }\r\n" + 
				"        Common_Logger.info(\"\\uC740\\uD589\\uC601\\uC5C5\\uC77C\\uC774 \\uC544\\uB2D8 \\uBC30\\uCE58 \\uC2E4\\uD589\\uC548\\uD568\");\r\n" + 
				"    }\r\n" + 
				"\r\n" + 
				"    private KFTCPayDataBean cancelPayment(String originPay_date, String tx_amount, String originSerialNo, String tx_user_define, PaymentDataBean alreadyPayData)\r\n" + 
				"        throws Exception\r\n" + 
				"    {\r\n" + 
				"        KFTCPayDataBean _KFTCData = new KFTCPayDataBean();\r\n" + 
				"        String _payDate = originPay_date;\r\n" + 
				"        String _TelegramSeqNo = \"\";\r\n" + 
				"        String _PaymentId = \"\";\r\n" + 
				"        String _PaymentTime = dateUtil.getCurrentDate(\"HHmmss\");\r\n" + 
				"        String _TransactionDate = dateUtil.getCurrentDate(\"yyMMdd\");\r\n" + 
				"        String _PnrAlpha = strUtil.n2b(alreadyPayData.getPnrAlpha());\r\n" + 
				"        String _PnrNumeric = strUtil.n2b(alreadyPayData.getPnrNumeric());\r\n" + 
				"        _payDate = _payDate.replaceAll(\"[^0-9]\", \"\").trim();\r\n" + 
				"        _TelegramSeqNo = payCommon.getTelegramSeq(7);\r\n" + 
				"        _PaymentId = payCommon.getPaymentIDBySEQ();\r\n" + 
				"        if(strUtil.n2b(originPay_date).trim().length() <= 0)\r\n" + 
				"        {\r\n" + 
				"            Common_Logger.info(\"\\uC6D0\\uAC70\\uB798\\uC77C\\uC790, \\uC6D0\\uAC70\\uB798\\uC77C\\uB828\\uBC88\\uD638, \\uAE08\\uC561\\uC740 \\uBC18\\uB4DC\\uC2DC \\uC874\\uC7AC\\uD574\\uC57C \\uD569\\uB2C8\\uB2E4.\");\r\n" + 
				"            throw new Exception(\"PARAMETER CHECK!! - originPay_date\");\r\n" + 
				"        }\r\n" + 
				"        if(strUtil.n2b(originSerialNo).trim().length() <= 0)\r\n" + 
				"        {\r\n" + 
				"            Common_Logger.info(\"\\uC6D0\\uAC70\\uB798\\uC77C\\uC790, \\uC6D0\\uAC70\\uB798\\uC77C\\uB828\\uBC88\\uD638, \\uAE08\\uC561\\uC740 \\uBC18\\uB4DC\\uC2DC \\uC874\\uC7AC\\uD574\\uC57C \\uD569\\uB2C8\\uB2E4.\");\r\n" + 
				"            throw new Exception(\"PARAMETER CHECK!! - originSerialNo\");\r\n" + 
				"        }\r\n" + 
				"        if(strUtil.n2b(tx_amount).trim().length() <= 0)\r\n" + 
				"        {\r\n" + 
				"            Common_Logger.info(\"\\uC6D0\\uAC70\\uB798\\uC77C\\uC790, \\uC6D0\\uAC70\\uB798\\uC77C\\uB828\\uBC88\\uD638, \\uAE08\\uC561\\uC740 \\uBC18\\uB4DC\\uC2DC \\uC874\\uC7AC\\uD574\\uC57C \\uD569\\uB2C8\\uB2E4.\");\r\n" + 
				"            throw new Exception(\"PARAMETER CHECK!! - tx_amount\");\r\n" + 
				"        }\r\n" + 
				"        if(!strUtil.isDigit(tx_amount))\r\n" + 
				"        {\r\n" + 
				"            Common_Logger.info(\"\\uAE08\\uC561\\uC740 \\uBC18\\uB4DC\\uC2DC \\uC22B\\uC790\\uC5EC\\uC57C \\uD569\\uB2C8\\uB2E4.\");\r\n" + 
				"            throw new Exception(\"PARAMETER CHECK!! - tx_amount is numeric!!\");\r\n" + 
				"        }\r\n" + 
				"        PaymentDataBean payData = new PaymentDataBean();\r\n" + 
				"        payData.setTelegramSeqNo(_TelegramSeqNo);\r\n" + 
				"        payData.setTransactionDate(_TransactionDate);\r\n" + 
				"        payData.setOriginAuthDate(originPay_date);\r\n" + 
				"        payData.setOriginAuthCode(originSerialNo);\r\n" + 
				"        if(alreadyPayData.getXUserId().length() > 16)\r\n" + 
				"            payData.setXUserId(alreadyPayData.getXUserId().substring(0, 16));\r\n" + 
				"        else\r\n" + 
				"            payData.setXUserId(alreadyPayData.getXUserId());\r\n" + 
				"        payData.setAgentID(alreadyPayData.getAgentID());\r\n" + 
				"        payData.setPnrAlpha(_PnrAlpha);\r\n" + 
				"        payData.setPnrNumeric(_PnrNumeric);\r\n" + 
				"        payData.setPaymentID(_PaymentId);\r\n" + 
				"        payData.setPaymentTime(_PaymentTime);\r\n" + 
				"        payData.setMessageType(\"0420\");\r\n" + 
				"        payData.setCancelType(\"D\");\r\n" + 
				"        payData.setTransactionPayment(tx_amount);\r\n" + 
				"        payData.setXBankCode(alreadyPayData.getXBankCode());\r\n" + 
				"        payData.setXBankAccountNumber(alreadyPayData.getXBankAccountNumber());\r\n" + 
				"        payData.setXAccountName(alreadyPayData.getXAccountName());\r\n" + 
				"        payData.setXAccountContact(alreadyPayData.getXAccountContact());\r\n" + 
				"        payData.setXAuthActionType(\"P4\");\r\n" + 
				"        payData.setReceiptUse(alreadyPayData.getReceiptUse());\r\n" + 
				"        payData.setXInsertUser(\"BATCH\");\r\n" + 
				"        payData.setRefundDegree(alreadyPayData.getRefundDegree() + 1);\r\n" + 
				"        payCommon.insertPaymentHistory(payData, \"D\");\r\n" + 
				"        _KFTCData = refundPayment(originPay_date, tx_amount, originSerialNo, tx_user_define, String.valueOf(payData.getRefundDegree()), alreadyPayData.getAgentID());\r\n" + 
				"        payCommon.updateResponseCodeInTBHISPAYMENT(_TelegramSeqNo, _TransactionDate, _KFTCData.getResp_code(), _KFTCData.getFee());\r\n" + 
				"        if(!_KFTCData.getResp_code().equals(\"000\"))\r\n" + 
				"        {\r\n" + 
				"            KFTCRefundFailureDataBean _KFTCRefundFailure = new KFTCRefundFailureDataBean();\r\n" + 
				"            _KFTCRefundFailure.setOriginPaymentDate(originPay_date);\r\n" + 
				"            _KFTCRefundFailure.setOriginTelegramSeqNo(originSerialNo);\r\n" + 
				"            _KFTCRefundFailure.setResponseCode(_KFTCData.getResp_code());\r\n" + 
				"            _KFTCRefundFailure.setRefundAmount(tx_amount);\r\n" + 
				"            _KFTCRefundFailure.setUserDefineData(tx_user_define);\r\n" + 
				"            _KFTCRefundFailure.setPnrAlpha(_PnrAlpha);\r\n" + 
				"            _KFTCRefundFailure.setPnrNumeric(_PnrNumeric);\r\n" + 
				"            _KFTCRefundFailure.setModifyUser(payData.getXUserId());\r\n" + 
				"            _KFTCRefundFailure.setRefundProcess(\"F\");\r\n" + 
				"            _KFTCRefundFailure.setRefundDegree(payData.getRefundDegree());\r\n" + 
				"            _KFTCRefundFailure.setAgentID(payData.getAgentID());\r\n" + 
				"            payCommon.insertKFTCRefundFailure(_KFTCRefundFailure);\r\n" + 
				"        }\r\n" + 
				"        return _KFTCData;\r\n" + 
				"    }\r\n" + 
				"\r\n" + 
				"    private KFTCPayDataBean refundPayment(String originPay_date, String tx_amount, String originSerialNo, String tx_user_define, String tx_partial_cancel_cnt, String ps_agent_ID)\r\n" + 
				"        throws Exception\r\n" + 
				"    {\r\n" + 
				"        KFTCPayDataBean _KFTCData = new KFTCPayDataBean();\r\n" + 
				"        try\r\n" + 
				"        {\r\n" + 
				"            _KFTCData = refundPayment(\"0420\", \"EFT\", \"D\", originPay_date, tx_amount, originSerialNo, tx_user_define, tx_partial_cancel_cnt, ps_agent_ID);\r\n" + 
				"        }\r\n" + 
				"        catch(Exception ex)\r\n" + 
				"        {\r\n" + 
				"            Common_Logger.debug(ex);\r\n" + 
				"            ex.printStackTrace();\r\n" + 
				"        }\r\n" + 
				"        return _KFTCData;\r\n" + 
				"    }\r\n" + 
				"\r\n" + 
				"    private KFTCPayDataBean refundPayment(String hd_msg_code, String hd_msg_type, String hd_cancel_type, String originPay_date, String tx_amount, String originSerialNo, String tx_user_define, \r\n" + 
				"            String tx_partial_cancel_cnt, String ps_agent_ID)\r\n" + 
				"        throws Exception\r\n" + 
				"    {\r\n" + 
				"        String hd_resp_code = \"\";\r\n" + 
				"        String hd_trans_time = \"\";\r\n" + 
				"        String tx_cancel_remain = \"\";\r\n" + 
				"        String tx_cancel_date = \"\";\r\n" + 
				"        KFTCPayDataBean _KFTCData = new KFTCPayDataBean();\r\n" + 
				"        try\r\n" + 
				"        {\r\n" + 
				"            InitialMsg();\r\n" + 
				"            namevc.clear();\r\n" + 
				"            namevc = new Vector();\r\n" + 
				"            valuevc.clear();\r\n" + 
				"            valuevc = new Vector();\r\n" + 
				"            setEnvParameters();\r\n" + 
				"            setPayMsg(\"hd_msg_type\", hd_msg_type);\r\n" + 
				"            setPayMsg(\"hd_msg_code\", hd_msg_code);\r\n" + 
				"            setPayMsg(\"hd_password\", hd_password);\r\n" + 
				"            setPayMsg(\"hd_cancel_type\", hd_cancel_type);\r\n" + 
				"            setPayMsg(\"hd_pay_date\", originPay_date);\r\n" + 
				"            if(ps_agent_ID.equals(\"DIB\") || ps_agent_ID.equals(\"IIB\"))\r\n" + 
				"                setPayMsg(\"hd_approve_no\", hd_approve_no);\r\n" + 
				"            else\r\n" + 
				"                setPayMsg(\"hd_approve_no\", \"14001756\");\r\n" + 
				"            setPayMsg(\"hd_serial_no\", originSerialNo);\r\n" + 
				"            setPayMsg(\"tx_amount\", tx_amount);\r\n" + 
				"            setPayMsg(\"tx_partial_cancel_cnt\", tx_partial_cancel_cnt);\r\n" + 
				"            int result = getPayProc();\r\n" + 
				"            hd_resp_code = getPayMsg(\"hd_resp_code\");\r\n" + 
				"            hd_msg_type = getPayMsg(\"hd_msg_type\");\r\n" + 
				"            hd_approve_no = getPayMsg(\"hd_approve_no\");\r\n" + 
				"            originSerialNo = getPayMsg(\"hd_serial_no\");\r\n" + 
				"            originPay_date = getPayMsg(\"hd_pay_date\");\r\n" + 
				"            tx_amount = getPayMsg(\"tx_amount\");\r\n" + 
				"            hd_cancel_type = getPayMsg(\"hd_cancel_type\");\r\n" + 
				"            tx_partial_cancel_cnt = getPayMsg(\"tx_partial_cancel_cnt\");\r\n" + 
				"            tx_cancel_remain = getPayMsg(\"tx_cancel_remain\");\r\n" + 
				"            tx_cancel_date = getPayMsg(\"tx_cancel_date\");\r\n" + 
				"            _KFTCData.setResp_code(hd_resp_code);\r\n" + 
				"            _KFTCData.setMsg_type(hd_msg_type);\r\n" + 
				"            _KFTCData.setApprove_no(hd_approve_no);\r\n" + 
				"            _KFTCData.setSerial_no(originSerialNo);\r\n" + 
				"            _KFTCData.setPay_date(originPay_date);\r\n" + 
				"            _KFTCData.setCancel_type(hd_cancel_type);\r\n" + 
				"            _KFTCData.setTrans_time(hd_trans_time);\r\n" + 
				"            _KFTCData.setAmount(tx_amount);\r\n" + 
				"            _KFTCData.setUser_define(tx_user_define);\r\n" + 
				"            _KFTCData.setPartial_cancel_cnt(tx_partial_cancel_cnt);\r\n" + 
				"            _KFTCData.setCancel_remain(tx_cancel_remain);\r\n" + 
				"            _KFTCData.setCancel_date(tx_cancel_date);\r\n" + 
				"        }\r\n" + 
				"        catch(Exception ex)\r\n" + 
				"        {\r\n" + 
				"            _KFTCData.setResp_code(\"999\");\r\n" + 
				"            Common_Logger.debug(ex);\r\n" + 
				"            ex.printStackTrace();\r\n" + 
				"        }\r\n" + 
				"        return _KFTCData;\r\n" + 
				"    }\r\n" + 
				"\r\n" + 
				"    private void setEnvParameters()\r\n" + 
				"        throws Exception\r\n" + 
				"    {\r\n" + 
				"        String _TX_IP = \"\";\r\n" + 
				"        String _TX_SERV_PORT = \"\";\r\n" + 
				"        String _TX_TIMEOUT = \"\";\r\n" + 
				"        String _CANCEL_TIMEOUT = \"\";\r\n" + 
				"        String _ipgumlog = \"\";\r\n" + 
				"        try\r\n" + 
				"        {\r\n" + 
				"            java.io.InputStream _inputStream = super.getClass().getResourceAsStream(\"/KFTCPay.properties\");\r\n" + 
				"            Properties _properties = new Properties();\r\n" + 
				"            _properties.load(_inputStream);\r\n" + 
				"            _TX_IP = _properties.getProperty(\"TX_IP\");\r\n" + 
				"            _TX_SERV_PORT = _properties.getProperty(\"TX_SERV_PORT\");\r\n" + 
				"            _TX_TIMEOUT = _properties.getProperty(\"TX_TIMEOUT\");\r\n" + 
				"            _CANCEL_TIMEOUT = _properties.getProperty(\"CANCEL_TIMEOUT\");\r\n" + 
				"            _ipgumlog = _properties.getProperty(\"ipgumlog\");\r\n" + 
				"            hd_approve_no = _properties.getProperty(\"approve_no\");\r\n" + 
				"            hd_password = _properties.getProperty(\"hd_password\");\r\n" + 
				"            Common_Logger.info(\"====== CONFIG VALUE START!====== \");\r\n" + 
				"            Common_Logger.info((new StringBuilder(\"TX_IP :\")).append(_TX_IP).toString());\r\n" + 
				"            Common_Logger.info((new StringBuilder(\"TX_SERV_PORT :\")).append(_TX_SERV_PORT).toString());\r\n" + 
				"            Common_Logger.info((new StringBuilder(\"TX_TIMEOUT :\")).append(_TX_TIMEOUT).toString());\r\n" + 
				"            Common_Logger.info((new StringBuilder(\"CANCEL_TIMEOUT :\")).append(_CANCEL_TIMEOUT).toString());\r\n" + 
				"            Common_Logger.info((new StringBuilder(\"hd_approve_no :\")).append(hd_approve_no).toString());\r\n" + 
				"            Common_Logger.info((new StringBuilder(\"hd_password :\")).append(hd_password).toString());\r\n" + 
				"            Common_Logger.info(\"====== CONFIG VALUE END!====== \");\r\n" + 
				"            SetEnvParameter(\"TX_IP\", _TX_IP);\r\n" + 
				"            SetEnvParameter(\"TX_SERV_PORT\", _TX_SERV_PORT);\r\n" + 
				"            SetEnvParameter(\"TX_TIMEOUT\", _TX_TIMEOUT);\r\n" + 
				"            SetEnvParameter(\"CANCEL_TIMEOUT\", _CANCEL_TIMEOUT);\r\n" + 
				"            SetEnvParameter(\"ipgumlog\", _ipgumlog);\r\n" + 
				"        }\r\n" + 
				"        catch(Exception ex)\r\n" + 
				"        {\r\n" + 
				"            throw ex;\r\n" + 
				"        }\r\n" + 
				"    }\r\n" + 
				"\r\n" + 
				"    public String getSerial_no()\r\n" + 
				"        throws Exception\r\n" + 
				"    {\r\n" + 
				"        String _TelegramSeq = \"\";\r\n" + 
				"        try\r\n" + 
				"        {\r\n" + 
				"            _TelegramSeq = payCommon.getTelegramSeq(7);\r\n" + 
				"        }\r\n" + 
				"        catch(Exception ex)\r\n" + 
				"        {\r\n" + 
				"            throw ex;\r\n" + 
				"        }\r\n" + 
				"        return _TelegramSeq;\r\n" + 
				"    }\r\n" + 
				"\r\n" + 
				"    private String hd_approve_no;\r\n" + 
				"    private String hd_password;\r\n" + 
				"    private KFTCPaymentCommon payCommon;\r\n" + 
				"    private StringUtil strUtil;\r\n" + 
				"    private DateUtil dateUtil;\r\n" + 
				"    protected Log Common_Logger;\r\n" + 
				"    private Connection con;\r\n" + 
				"    private String FROM_DATE;\r\n" + 
				"}\r\n" + 
				""));
	}
	
	
	// 유니코드에서 String으로 변환
	public static String convertString(String val) {
		// 변환할 문자를 저장할 버퍼 선언
		StringBuffer sb = new StringBuffer();
		// 글자를 하나하나 탐색한다.
		for (int i = 0; i < val.length(); i++) {
			/* 
			 * 조합이 \\u로 시작하면 6글자를 변환한다. \\uxxxx
			 */
			if ('\\' == val.charAt(i) && 'u' == val.charAt(i + 1)) {
				// 그 뒤 네글자는 유니코드의 16진수 코드이다. int형으로 바꾸어서 다시 char 타입으로 강제 변환한다.
				Character r = (char) Integer.parseInt(val.substring(i + 2, i + 6), 16);
				// 변환된 글자를 버퍼에 넣는다.
				sb.append(r);
				// for의 증가 값 1과 5를 합해 6글자를 점프
				i += 5;
			} else {
				// ascii코드면 그대로 버퍼에 넣는다.
				sb.append(val.charAt(i));
			}
		}
		// 결과 리턴
		return sb.toString();
	}
	
}
