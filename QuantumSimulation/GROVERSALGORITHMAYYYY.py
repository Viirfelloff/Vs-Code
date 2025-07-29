from qiskit import QuantumCircuit
import QuantumShortcuts

#Step 0: Initialize
qc = QuantumShortcuts.create(2,2)

#Step 1: Apply Hadamard Gate to all Qubits
qc.h([0,1])

#Step 2: Oracle Operator (Sign Change)
qc.cz(0,1)
#Step 3: Diffusion
qc.h([0, 1])
qc.x([0, 1])
qc.h(1)
qc.cx(0, 1)
qc.h(1)
qc.x([0, 1])
qc.h([0, 1])
qc.measure([0,1],[0,1])

QuantumShortcuts.displayInfo(qc)


