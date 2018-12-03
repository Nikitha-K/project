# -*- coding: utf-8 -*-
from __future__ import unicode_literals

from django.core.serializers import json
from django.db.models import Q
from django.shortcuts import render, redirect
from django.views.decorators.csrf import csrf_exempt
import csv, io
from django.contrib import messages
from django.shortcuts import HttpResponse
from django.views.generic import View

from .models import Employee


@csrf_exempt
def home(request):
    return render(request, "json1.html")


def addemployee(request):
    return render(request, "AddEmployee.html");


@csrf_exempt
def adddata(request):
    if request.is_ajax():
        response = HttpResponse()
        try:
            name = request.POST.get('name')
            print name
            gmail = request.POST.get('gmail')
            print gmail
            mobile = request.POST.get('mobile')
            operation = request.POST.get('operation')
            print mobile
            if operation == "add":
                e = Employee(name=name, gmail=gmail, mobile=mobile)
                e.save()
            else:
                Employee.objects.filter(gmail=gmail).update(name=name, mobile=mobile)
        except:
            print("something is wrong")
            response.status_code = 400
            return response

        response.status_code = 200
        return response
    else:
        return redirect(request, 'json1.html')


def viewall(request):
    emplist = Employee.objects.all()
    return render(request, "viewall.html", {"emplist": emplist})


@csrf_exempt
def delete(request, emp_id):
    emp = Employee.objects.get(pk=emp_id)
    emp.delete()
    emplist = Employee.objects.all()
    response = HttpResponse()
    response.status_code = 200
    return response


class update(View):
    def get(self, request, emp_id):
        emp = Employee.objects.get(pk=emp_id)
        return render(request, "update.html", {"emp": emp})


@csrf_exempt
def uploaddata(request):
    if request.is_ajax():
        values = json.loads(request.POST.get('values'))
        print(values)

    return redirect(request, 'json1.html')


@csrf_exempt
def search(request):
    if request.method == 'POST':
        value = request.POST.get('search')
        emplist = Employee.objects.filter(
            Q(name__icontains=value) | Q(gmail__icontains=value) | Q(mobile__icontains=value))

        l = len(emplist)

        return render(request, "search.html", {"emplist": emplist, "matcheddata": emplist, "l": l})


@csrf_exempt
def upload(request):
    if request.method == 'POST':
        try:
            csv_file = request.FILES['file']
        except:
            messages.error(request, "choose csv file")
            return render(request, "json1.html")

        if not csv_file.name.endswith('.csv'):
            messages.error(request, "this is not a valid csv file")
        else:
            data_set = csv_file.read().decode('utf-8')
            print(data_set)
            print(type(data_set))
            io_string = io.StringIO(data_set)
            print(io_string)
            print(type(io_string))
            next(io_string)
            inserted = 0
            for column in csv.reader(io_string, delimiter=str(",")):
                if column[1].isdigit() and len(column[1]) == 10 and not (column[0].isdigit()):
                    e = Employee(name=column[0], gmail=column[2], mobile=column[1])
                    try:
                        e.save()
                        inserted += 1
                    except:
                        print("email should be unique")

            messages.error(request, "total records inserted is {0}. check data if all records are not inserted ".format(
                inserted))

    return render(request, "json1.html")


def download(request):
    items = Employee.objects.all()
    response = HttpResponse(content_type='text/csv')
    response['Content-Disposition'] = 'attachment; filename="data.csv"'
    writer = csv.writer(response, delimiter=str(","))
    writer.writerow(['name', 'mobile', 'gmail'])
    for obj in items:
        writer.writerow([obj.name, obj.mobile, obj.gmail])

    return response
