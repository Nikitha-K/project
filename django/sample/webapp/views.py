# -*- coding: utf-8 -*-
from __future__ import unicode_literals

import datetime


from django.shortcuts import render,get_object_or_404, redirect
from django.contrib.auth.models import User

# Create your views here.

from django.http import HttpResponse

from webapp.models import Board,Topic,Post
from .forms import newTopicForm

def home(request):
    board_objects=Board.objects.all()
    boards_names=list()
    for board in board_objects:
        boards_names.append(board.name)
    return HttpResponse("<br>".join(boards_names))

def home1(request):
    board_objects=Board.objects.all()
    return render(request,"home1.html",{"Boards":board_objects})

def Board_Topics(request,id):
    board=get_object_or_404(Board,id=id)
    return render(request,"Topics.html",{"Board":board})



def new_topic(request,id):
    board=get_object_or_404(Board,id=id)
    user = User.objects.latest('id')

    if request.method=="POST":
        form = newTopicForm(request.POST)
        print "akhil"
        if form.is_valid():
            topic=form.save(commit=False)
            topic.board=board
            topic.starter=user
            topic.save()
            post = Post.objects.create(
                message=form.cleaned_data.get("message"),
                created_by=user,
                topic=topic
            )


        return redirect('Board_Topic', pk=board.pk)
    else:
        form = newTopicForm()
        print "dome"

        return render(request, 'new_topic.html', {"Board": board,"forms":form})


