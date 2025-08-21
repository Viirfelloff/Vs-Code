from qiskit import QuantumCircuit
import QuantumShortcuts

# Bell State 1: 01 + 10
qc = QuantumCircuit(2,2)

qc.h(1)

qc.x([0,1])

qc.cnot(0,1)

qc.cx(1,0)

qc.measure([0,1],[0,1])

# Bell State 2: 01 - 10
qc2 = QuantumCircuit(2,2)

qc2.h(1)

qc2.x([0,1])

qc2.cnot(0,1)

qc2.cx(1,0)

qc2.x(1)

qc2.cz(0,1)

qc2.x(1)

qc2.measure([0,1],[0,1])

# Bell State 3: 00 + 11

qc3 = QuantumCircuit(2,2)

qc3.h(1)

qc3.cx(1,0)

qc3.measure([0,1],[0,1])

# Bell State 4: 00 - 11

qc4 = QuantumCircuit(2,2)

qc4.h(1)

qc4.cx(1,0)

qc4.cz(0,1)

qc4.measure([0,1],[0,1])

QuantumShortcuts.displayInfo(qc)

QuantumShortcuts.displayInfo(qc2)

QuantumShortcuts.displayInfo(qc3)

QuantumShortcuts.displayInfo(qc4)

#Explanation:
