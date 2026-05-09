import requests

url = "http://127.0.0.1:5000/calc?a=10&b=20&op=div"

response = requests.get(url)

data = response.json()

print(data)
print("Response from server:")
print("Result =", data["result"])