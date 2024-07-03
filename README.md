#include <avr/io.h>
#include <avr/interrupt.h>
#include <util/delay.h>

unsigned char digit[10] = {0xc0, 0xf9, 0xa4, 0xb0, 0x99, 0x92, 0x82, 0xf8, 0x80, 0x90};//fnd 숫자 10개 (0 ~ 9)
unsigned char latch[4] = {0x01, 0x02, 0x04, 0x08}; //자리수
int i,count = 0, fnd1,fnd10,fin100,fnd1000;//변수선언 
int count, run;// 변수 
int main(void) //메인함수 
 { 
   DDRA = 0xff; //A포트 출력 설정
   DDRD = 0xff; //A포트 출력 설정
   DDRE = 0x0f; //E포트 입출력 설정
   PORTE = 0xff; //E포트 초기 설정 
 }
