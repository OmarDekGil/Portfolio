
import random
class Inicio:
    
    def __init__(self):
        # Establecer horario y condiciones iniciales
        
        self.temp = random.randint(0, 40)
        self.amanecerH = int(input("Introduce la hora de amanecer: "))
        self.anochecerH = int(input("Introduce la hora de anochecer: "))
        self.actualH = int(input("Introduce la hora actual: "))
        self.simulH = int(input("¿Cuantas horas quieres simular?"))
        self.BatSol = int(100)
        self.hPog = int(input("Introduce la hora a la que quieras que se active la lavadora:"))
        self.Alarma = True
        
        self.alarmaH = random.randint(0, 23)
        self.sensor = SensorTemp(self.temp, self)
        self.electrodomesticos = Electrodomesticos(self.hPog, self)
        self.alarma = AlarmaPresencia(self.alarmaH,self.Alarma, self)
        self.persianas = Persianas(self)
        self.bateria = Bateria(self.BatSol, self)
        
    def simular_paso_horas(self):
        for _ in range(self.simulH):
            
            # Aquí actualizas el estado de los dispositivos y sensores en cada iteración
            
            print("###################################")
            print("# Son las ",self.actualH," y hace ",self.temp," grados #")
            print("###################################")  
            print("")         
            self.sensor.AireCalefaccion()
            print("")
            self.electrodomesticos.Lavadora()
            print("")
            self.alarma.SaltaAlarma()
            print("")
            self.bateria.bateria()
            print("")           
            self.persianas.persiana()
            input("Pulsa enter para pasar de hora")
            print("")
            
            self.actualH = self.actualH + 1
            
            if self.actualH == 24:
                self.actualH = 0
                self.temp = random.randint(0, 40)
            
            
    

# Clase SensorTemp
class SensorTemp:
    def __init__(self, temp, inicio):
        self.temp = temp
        self.inicio = inicio
    
    def AireCalefaccion(self):
        if self.temp >= 30:   
            print("El aire acondicionado está encendido")
        elif self.temp <=10:
            print("La calefaccion esta encendida")

# Clase Electrodomesticos
class Electrodomesticos:
    def __init__(self, hPog, inicio):
        self.hPog = hPog
        
        self.inicio = inicio
    
    def Lavadora(self):
        if self.inicio.actualH == self.hPog:
            
            print("Se acaba de encender la lavadora")
        else: 
            print("La lavadora sigue apagada")

# Clase AlarmaPresencia
class AlarmaPresencia:
    def __init__(self, alarmaH , AlarmaH, inicio):
        self.alarmaH = alarmaH
        self.Alarma = AlarmaH
        self.pssw = int(123)
        self.inicio = inicio
    def SaltaAlarma(self):
        if self.alarmaH == self.inicio.actualH:
           print("¡¡¡¡Se ha detectado tu presencia con la alarma!!!!")
           while self.Alarma:
            try:
                self.pasw = int(input("Introduce la contraseña numérica: "))

                if self.pasw == self.pssw:
                        print("La contraseña es correcta, alarma desconectada")
                        self.Alarma = False
                else:
                        print("La contraseña es incorrecta, es MUY fácil")

            except ValueError:
                print("Entrada inválida. Pon algo vaguete")
                      
        else:
            print("* Alarma apagada *")

# Clase Persianas
class Persianas:
    def __init__(self, inicio):
        
        self.inicio = inicio
    def persiana(self):    
        if self.inicio.actualH == self.inicio.anochecerH:
            
            print("Las persianas se han bajado, a mimir")
        elif self.inicio.actualH == self.inicio.amanecerH:       
            print("Las persianas se han subido, Buenos dias")

# Clase Bateria
class Bateria:
    def __init__(self, BatSol, inicio):
        self.BatSol = int(BatSol)
        self.inicio = inicio

    def bateria(self):
        if self.BatSol == 25:
            print("Se está cambiando a consumo eléctrico")
        elif self.BatSol == 0:
            self.BatSol = 100
            print("La batería se ha recargado al 100%")
        else:
            print("Se está usando batería solar")
            
        self.BatSol -= 25

# Resto del código...

# Método simular_paso_horas


inicio = Inicio()
inicio.simular_paso_horas()
