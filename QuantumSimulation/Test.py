from qiskit import QuantumCircuit
import QuantumShortcuts
#Experimenting with bloch sphere and new gates
qc = QuantumCircuit(1,1)

qc.h(0)
qc.p(90,0)
qc.sx(0)

qc.measure(0,0)

QuantumShortcuts.displayInfo(qc)
