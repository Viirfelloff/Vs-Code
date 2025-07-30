from qiskit import QuantumCircuit
import QuantumShortcuts
qc = QuantumCircuit(2,2)

qc.h([0,1])

qc.x(1)

qc.h(0)
qc.measure([0,1],[0,1])
QuantumShortcuts.displayInfo(qc)