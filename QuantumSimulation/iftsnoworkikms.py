from qiskit import QuantumCircuit
import QuantumShortcuts

qc = QuantumShortcuts.create(4,4)
qc.h(0)
qc.h(2)
qc.cx(0, 1)
qc.cx(2,3)
qc.cx(0,3)
qc.cx(1,2)
qc.x(3)
qc.measure([0,1,2,3], [0,1,2,3])

QuantumShortcuts.displayInfo(qc)
