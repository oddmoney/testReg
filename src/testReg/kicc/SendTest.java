package testReg.kicc;

import testReg.testSocket.SocketUtils;

public class SendTest {
	public static void main(String[] args) {
		//testKicc();
		//testKiccOnline();
		testKmps();
	}
	
	private static void testKmps() {
		try {
			//String host = "dnesb.jejuair.net";
			//String port = "30302";
			String host = "177.200.3.151";
			String port = "22071"; //"22044";
			//String reqMsg =   "JEJUAIRH9S9C45635440                 21041417488602002010718540@4046783181864405=1111                00000010300000000000000000000000                  JJ000000233871511                                                              \r";
			//String reqMsg =   "JEJUAIRAPQQ30                        06021400000102001010718540@4518430084972054=0910101473991700000000000000100000000000000000000000                                                                                           \r";
			//String reqMsg =   "JEJUAIRAPQQ30                        13042100000102001010718540@4518430084972054=0910101473991700000000000000100000000000000000000000                                                                                           \r";
			//String reqMsg =   "JEJUAIR                              15042164806502001010718540@4111111111111111=2212                00000000150000000000000000000000                                                                                                 \r";
			//String reqMsg =   "JEJUAIR                              06120217488602002010718540@4046783181864405=1111                00000010300000000000000000000000                  JJ000000233871511                                                              \r";
			//String reqMsg =   "JEJUAIR                              14042164806502001010718540@4111111111111111=2212                00000000150000000000000000000000                                                                                                 \r";
			  String reqMsg =   "JEJUAIRL2C5GI                        21070965234202001010718540@5111111111111111=2606                00000000850000000000000000000000                                                                                                 \r";
			//String reqMsg =   "JEJUAIRL2C5GI                        21070165234202001010718540@4111111111111111=2212                00000000850000000000000000000000                                                                                                 \r";

			System.out.println("###Req-Msg:::"+reqMsg);
			
			byte[] resByt = new SocketUtils().sendSocket(reqMsg.getBytes(), host, port);
			//String str = new SocketUtils().sendKmpsSocket(reqMsg.getBytes(), host, port);
			System.out.println("#####MSG:::"+new String(resByt, EntityRange.KICC_RES_CHAR));

			EntityKiccVo resVo = new EntityKiccParse().getApproveResKiccVo(resByt);
			System.out.println("===========[PayKiccOfflineCard.approveProcessOffline]resVo:::"+resVo.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void testKicc() {
		try {
			//String host = "dnesb.jejuair.net";
			//String host = "nesb.jejuair.net"; // LIVE ESB (주의요망)
			//String port = "30301";
			String host = "203.209.3.11";
			//String host = "203.209.3.6"; // LIVE 서버 (주의요망)
			String port = "4021";
			
			//String host = "177.200.3.151"; // KMPS
			//String port = "22071"; // KMPS
			
			//String reqMsg = "JEJUAIRH7TFK49049035                 210401647869020010106424  @1111111111111111=2512                00000007400000000000000000000000                  JJ880916000000011                                                              \r";
			//String reqMsg = "JEJUAIRAPQQ30                        210401647869020010106424  @4109000000000000=2512                00000001000000000000000000000000                                                                                                 \r";
			//String reqMsg = "JEJUAIRAPQQ41                        210416648150042010788888  @4111000000000000=2501                0000000010000000000000000000000021041699091524                                                                                   \r";
			//String reqMsg = "JEJUAIR                              21042364806802001010718540@6258040434939007=2407                00000000150000000000000000000000                                                                                                 \r";
			//String reqMsg = "JEJUAIR                              210506648068020010788888  @4111000000000000=2407                00000000150000000000000000000000                                                                                                 \r";
			//String reqMsg = "JEJUAIR                              210506648068020010788888  @4118961111111111=2204                01000000150000000000000000000000                                                                                                 \r";
			//String reqMsg = "JEJUAIR                              210506648068020010788888  @4135261111111111=2204                01000000150000000000000000000000                                                                                                 \r";
			//String reqMsg = "JEJUAIR                              210506648068020010788888  @4137201111111111=2204                01000000150000000000000000000000                                                                                                 \r";
			//String reqMsg = "JEJUAIR                              210506648068020010788888  @4111111111111111=2204                01000000150000000000000000000000                                                                                                 \r";
			//String reqMsg = "JEJUAIR                              210506648068020010788888  @5531770010070709=2207                01000000150000000000000000000000                                                                                                 \r";
			//String reqMsg = "JEJUAIR                              210506648068020010788888  @5409268483275068=2107                01000000150000000000000000000000                                                                                                 \r";
			//String reqMsg = "JEJUAIR                              210511648068020010788888  @4118961111111112=2207                03000000150000000000000000000000                                                                                                 \r";
			//String reqMsg = "JEJUAIR                              210511648068020010788888  @4118961111111112=2207                00000000150000000000000000000000                                                                                                 \r";
			//String reqMsg = "JEJUAIR                              210511648068020010788888  @4111111111111111=2207                00000000150000000000000000000000                                                                                                 \r";
			//String reqMsg = "JEJUAIRL2C5GI                        210616652342020010788888  @4111111111111111=2510                00000000850000000000000000000000                                                                                                 \r";

			//현금영수증 (주민번호)
			//String reqMsg = "JEJUAIR94XYC3268829774826884         2106091035650700109999999 @7712171446824                        00000888000000000000000000000000                                                                                                 \r";
			//현금영수증 (전화번호)
			//String reqMsg = "JEJUAIR94XYC3268829774826884         2106091035650700109999999 @01089093587                          00000008000000000000000000000000                  JJ                                                                             \r";
			//String reqMsg = "JEJUAIR94XYC3268829774826884         2106091035650700109999999 @7712171446824                        00000008000000000000000000000000                  BB                                                                             \r";
			//현금영수증 (사업자번호)
			//String reqMsg = "JEJUAIR94XYC3268829774826884         2106091035650700109999999 @6168150527                           01000008000000000000000000000000                                                                                                 \r";
			//현금영수증 (카드)
			//String reqMsg = "JEJUAIRH7TFK49049035                 210609103565070010106424  A1111040434939117                     00000007400000000000000000000000                                                                                                 \r";
			//현금영수증카드
			//String reqMsg = "JEJUAIRH7TFK49049035                 210609103565070010106424  A111104043493911723                   00000007400000000000000000000000                                                                                                 \r";
			  String reqMsg = "JEJUAIRK7KEPW268829774826884         210827103565070010106424  @7712171446824                        00000008000000000000000000000000                  JJ                                                                             \r";
			// 테스트MID(788888) 로 임의카드 로 할부기간 00으로 보내면 성공, 할부기간 01~ 로 보내면 오류 (8001)
			// 테스트MID(788888) 로 테스트카드 할부기간 00, 01~ 보내면 성공
			// 테스트카드
			// 4118961111111111 (KB국민카드)
			// 4135261111111111 (현대VISA카드)
			// 4137201111111111 (삼성VISA카드)
			
			
			System.out.println("###Req-Msg:::"+reqMsg);
			
			byte[] resByt = new SocketUtils().sendSocket(reqMsg.getBytes(), host, port);
			System.out.println("===========[sendSocket]resStr:::"+new String(resByt, EntityRange.KICC_RES_CHAR));
			
			EntityKiccVo resVo = new EntityKiccParse().getApproveResKiccVo(resByt);
			System.out.println("===========[PayKiccOfflineCard.approveProcessOffline]resVo:::"+resVo.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void testKiccOnline() {
		try {
			//String host = "203.209.3.11";
			//String port = "14110";
			String host = "dnesb.jejuair.net";
			String port = "30303";
			//String reqMsg = "043502104018141    JJAIR00000064777815JEJUAIR             02-1599-1500 010-0000-0000                                           1210K                                     0010000000000000000000000000000000000000251354      210406AA0000000000000000A839UT           www.jejuair.net                                                       1                                                                                                         \r";
			//String reqMsg = "043502104788888    JJAIR00000064777815JEJUAIR             02-1599-1500 010-0000-0000                                           1210K4111111111111111=0125                0010000000000000000000000000000000000000251354      210406AA0000000000000000A839UT           www.jejuair.net                                                       1                                                                                                         \r";
			//String reqMsg = "043502104018141    JJAIR00000000000315JEJUAIR             02-1599-1500 010-0000-0000                                           1210K                                     0012000000001900000000000000000000000000940415      210407AA0000000000000000A839UT           www.jejuair.net                                                       1                                                                                                         \r";
			//String reqMsg = "043502106788888    JJAIR00000065229515JEJUAIR             02-1599-1500 010-0000-0000                                           1210K4111111111111111=1222                0010000000021200000000000000000000000000824538      210615AA0000000000000000AQPQ31           www.jejuair.net                                                       1                                                                                                         \r";
			
 			//String reqMsg = "04350210610140185  JJAIR00000065369715JEJUAIR             02-1599-1500 010-0000-0000                                           1210K5570420404256058=1025                005300000110000000000000000000000000000061731475    210625AA0000000000000000VC243X           www.jejuair.net                                                       1                                                                                                         \r";
 			//String reqMsg = "04350210610140185  JJAIR00000065369715JEJUAIR             02-1599-1500 010-0000-0000                                           1210K                                     005300000110000000000000000000000000000061731475    210625AA0000000000000000VC243X           www.jejuair.net                                                       1                                                                                                         \r";
 			//String reqMsg = "043502106018141    JJAIR00000065369715JEJUAIR             02-1599-1500 010-0000-0000                                           1210K5570420404256058=1025                005300000110000000000000000000000000000061731475    210625AA0000000000000000VC243X           www.jejuair.net                                                       1                                                                                                         \r";
 			//String reqMsg = "043502106018141    JJAIR00000065369715JEJUAIR             02-1599-1500 010-0000-0000                                           1210K                                     005300000110000000000000000000000000000061731475    210625AA0000000000000000VC243X           www.jejuair.net                                                       1                                                                                                         \r";
			  String reqMsg = "043402106018141    JJAIR00000065380115JEJUAIR             02-1599-1500 010-0000-0000                                           1210K4111111111111111=1025                0053000001100000000000000000000000000000176349      210628AA0000000000000000VC243X           www.jejuair.net                                                       1                                                                                                         \r";
			//String reqMsg = "043502106018141    JJAIR00000065380115JEJUAIR             02-1599-1500 010-0000-0000                                           1210K                                     0053000001100000000000000000000000000000176349      210628AA0000000000000000VC243X           www.jejuair.net                                                       1                                                                                                         \r";
			System.out.println("###Req-Msg:::"+reqMsg);
			
			byte[] resByt = new SocketUtils().sendSocket(reqMsg.getBytes(), host, port);
			System.out.println("===========[PayKiccOfflineCard.approveProcessOffline]resMsg:::"+new String(resByt, EntityRange.KICC_ONLINE_RES_CHAR));
			EntityKiccVo resVo = new EntityKiccParse().getOnlineResKiccVo(resByt);
			System.out.println("===========[PayKiccOfflineCard.approveProcessOffline]resVo:::"+resVo.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
