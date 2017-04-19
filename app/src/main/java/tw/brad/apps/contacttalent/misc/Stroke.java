package tw.brad.apps.contacttalent.misc;

public class Stroke {
	static int stroke = 0;
	
	public static String getStroke() {
		return String.valueOf(stroke);
	}

	public void setStroke(int stroke) {
		this.stroke = stroke;
	}

	public Stroke(String s){
		try {
   
            byte[] bytes = s.getBytes("big5");
            int b1 = (int) bytes[0] & 0xFF;
            int b2 = (int) bytes[1] & 0xFF;
 
            int b = (b1 << 8) + b2;
 
            //筆畫1
            if ((b == 0xA440) || (b == 0xA441)) { 
                stroke = 1;
            }
           //筆畫2
            else if (((b >= 0xA442) && (b <= 0xA453)) || ((b >= 0xC940) && (b <= 0xC944))) { 
                stroke = 2;
            }
           //筆畫3
            else if (((b >= 0xA454) && (b <= 0xA47E)) || ((b >= 0xC945) && (b <= 0xC94C))) { 
                stroke = 3;
            }
          //筆畫4
            else if (((b >= 0xA4A1) && (b <= 0xA4FD)) || ((b >= 0xC94D) && (b <= 0xC962))) { 
                stroke = 4;
            }
          //筆畫5
            else if (((b >= 0xA4FE) && (b <= 0xA5DF)) || ((b >= 0xC963) && (b <= 0xC9AA))) { 
                stroke = 5;
            }
            //6
            else if (((b >= 0xA5E0) && (b <= 0xA6E9)) || ((b >= 0xC9AB) && (b <= 0xCA59))) { 
                stroke = 6;
            }
            //7 
            else if (((b >= 0xA6EA) && (b <= 0xA8C2)) || ((b >= 0xCA5A) && (b <= 0xCBB0))) { 
                stroke = 7;
            }
            //8 
            else if (((b == 0xA260) || (b >= 0xA8C3) && (b <= 0xAB44)) || ((b >= 0xCBB1) && (b <= 0xCDDC))) { 
                stroke = 8;
            }
            //9 
            else if ((b == 0xA259) || (b == 0xF9DA) || ((b >= 0xAB45) && (b <= 0xADBB)) || ((b >= 0xCDDD) && (b <= 0xD0C7))) { 
                stroke = 9;
            }
            //10
            else if ((b == 0xA25A) || ((b >= 0xADBC) && (b <= 0xB0AD)) || ((b >= 0xD0C8) && (b <= 0xD44A))) { 
                stroke = 10;
            }
            //11
            else if ((b == 0xA25B) || (b == 0xA25C) || ((b >= 0xB0AE) && (b <= 0xB3C2)) || ((b >= 0xD44B) && (b <= 0xD850))) { 
                stroke = 11;
            }
            //12
            else if ((b == 0xF9DB) || ((b >= 0xB3C3) && (b <= 0xB6C2)) || ((b >= 0xD851) && (b <= 0xDCB0))) { 
                stroke = 12;
            }
            //13
            else if ((b == 0xA25D) || (b == 0xA25F) || (b == 0xC6A1) || (b == 0xF9D6) || (b == 0xF9D8) 
                    || ((b >= 0xB6C3) && (b <= 0xB9AB)) || ((b >= 0xDCB1) && (b <= 0xE0EF))) { 
                stroke = 13;
            }
            //14
            else if ((b == 0xF9DC) || ((b >= 0xB9AC) && (b <= 0xBBF4)) || ((b >= 0xE0F0) && (b <= 0xE4E5))) { 
                stroke = 14;
            }
            //15
            else if ((b == 0xA261) || ((b >= 0xBBF5) && (b <= 0xBEA6)) || ((b >= 0xE4E6) && (b <= 0xE8F3))) { 
                stroke = 15;
            }
            //16
            else if ((b == 0xA25E) || (b == 0xF9D7) || (b == 0xF9D9) || ((b >= 0xBEA7) && (b <= 0xC074)) 
                    || ((b >= 0xE8F4) && (b <= 0xECB8))) { 
                stroke = 16;
            }
            //17
            else if (((b >= 0xC075) && (b <= 0xC24E)) || ((b >= 0xECB9) && (b <= 0xEFB6))) { 
                stroke = 17;
            }
            //18
            else if (((b >= 0xC24F) && (b <= 0xC35E)) || ((b >= 0xEFB7) && (b <= 0xF1EA))) { 
                stroke = 18;
            }
            //19
            else if (((b >= 0xC35F) && (b <= 0xC454)) || ((b >= 0xF1EB) && (b <= 0xF3FC))) { 
                stroke = 19;
            }
            //20
            else if (((b >= 0xC455) && (b <= 0xC4D6)) || ((b >= 0xF3FD) && (b <= 0xF5BF))) { 
                stroke = 20;
            }
            //21
            else if (((b >= 0xC4D7) && (b <= 0xC56A)) || ((b >= 0xF5C0) && (b <= 0xF6D5))) { 
                stroke = 21;
            }
            //22
            else if (((b >= 0xC56B) && (b <= 0xC5C7)) || ((b >= 0xF6D6) && (b <= 0xF7CF))) { 
                stroke = 22;
            }
            //23
            else if (((b >= 0xC5C8) && (b <= 0xC5F0)) || ((b >= 0xF7D0) && (b <= 0xF8A4))) { 
                stroke = 23;
            }
            //24
            else if (((b >= 0xC5F1) && (b <= 0xC654)) || ((b >= 0xF8A5) && (b <= 0xF8ED))) { 
                stroke = 24;
            }
            //25
            else if (((b >= 0xC655) && (b <= 0xC664)) || ((b >= 0xF8EE) && (b <= 0xF96A))) { 
                stroke = 25;
            }
            //26
            else if (((b >= 0xC665) && (b <= 0xC66B)) || ((b >= 0xF96B) && (b <= 0xF9A1))) { 
                stroke = 26;
            }
            //27
            else if (((b >= 0xC66C) && (b <= 0xC675)) || ((b >= 0xF9A2) && (b <= 0xF9B9))) { 
                stroke = 27;
            }
            //28
            else if (((b >= 0xC676) && (b <= 0xC678)) || ((b >= 0xF9BA) && (b <= 0xF9C5))) { 
                stroke = 28;
            }
            //29
            else if (((b >= 0xC679) && (b <= 0xC67C)) || ((b >= 0xF9C7) && (b <= 0xF9CB))) { 
                stroke = 29;
            }
            //30
            else if ((b == 0xC67D) || ((b >= 0xF9CC) && (b <= 0xF9CF))) { 
                stroke = 30;
            }
            //31
            else if (b == 0xF9D0) { 
                stroke = 31;
            }
            //32
            else if ((b == 0xC67E) || (b == 0xF9D1)) { 
                stroke = 32;
            }
            //33
            else if ((b == 0xF9C6) || (b == 0xF9D2)) { 
                stroke = 33;
            }
            //35
            else if (b == 0xF9D3) { 
                stroke = 35;
            }
            //36
            else if (b == 0xF9D4) { 
                stroke = 36;
            }
            //48
            else if (b == 0xF9D5) { 
                stroke = 48;
            }
 
        } catch (Exception e) {
            e.printStackTrace();
        }

		
	}
	
	public static void main(String[] args) {
		String s ="林";
		Stroke stroke = new Stroke(s);
        System.out.println(s+ "的筆畫:" + stroke.getStroke());

	}
		
	

}
