from flask import Flask, request, jsonify

app = Flask(__name__)

@app.route('/calc', methods=['GET'])
def calc():
    a = int(request.args.get('a'))
    b = int(request.args.get('b'))
    op = request.args.get('op')

    if op == "add":
        result = a + b
    elif op == "sub":
        result = a - b
    elif op == "mul":
        result = a * b
    elif op == "div":
        result = a / b
    else:
        return "Invalid operation"

    return jsonify({"result": result})

if __name__ == '__main__':
    app.run(port=5000)