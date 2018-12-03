# -*- coding: utf-8 -*-
from __future__ import unicode_literals

from django.contrib.auth.forms import UserCreationForm
from django.shortcuts import render, redirect

# Create your views here.
from django.shortcuts import render
from django.contrib.auth import login as auth_login
def signup(request):
    if request.method =='POST':
        form =UserCreationForm(request.POST)
        if form.is_valid():
            user=form.save()
            auth_login(request,user)
            return redirect("home1",{"user":user})
    else:
        form = UserCreationForm()
    return render(request, 'signup.html', {"forms": form})





