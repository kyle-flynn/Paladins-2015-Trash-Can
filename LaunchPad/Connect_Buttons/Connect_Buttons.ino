const int switchGround = P2_5;//Black wire

void setup() {
  Serial.begin(9600);
  pinMode(switchGround, INPUT_PULLUP);
  
  pinMode(RED_LED, OUTPUT);
  pinMode(GREEN_LED, OUTPUT);
}

void loop() {
  int variable = digitalRead(switchGround);
  
  if(variable != LOW){
    digitalWrite(RED_LED, HIGH);
    digitalWrite(GREEN_LED, LOW);
  } else {
    digitalWrite(GREEN_LED, HIGH);
    digitalWrite(RED_LED, LOW);
  }
  Serial.println("Hello");
  delay(100);
}
